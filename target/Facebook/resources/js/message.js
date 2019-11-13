var blah = document.querySelector("#blah");
var notifyButton = document.getElementById("notify");
var logoutButton = document.querySelector('#logout');

logoutButton.addEventListener('click', function(event){
	console.log('Disconnecting');
	stompClient.disconnect();
});


var socket = new WebSocket("ws://localhost:8080/Facebook/notification");
var stompClient = Stomp.over(socket);

blah.addEventListener('click', function() {
	stompClient.send('/app/checknotify',{}, "Check");
});
stompClient.connect({}, function(frame){
	if(window.Notification) {
		Notification.requestPermission().then((permission) => {
				if(permission === 'granted') {
					notifyButton.disabled = false;
				}
			});
	} else 
		alert('Notification not supported. Notifications cannot be displayed.');
	
	stompClient.subscribe('/topic/checknotify', function(message){
		var str = message.body;
		if(str === "Notification_Available") {
			console.log(str);
			messageSend();
		} else if(str === 'Notification_Unavailable') {
			console.log('No notifications available');
		} else {
			var subdata = 'user(s)';
			if(str.includes(subdata)) {
				if(window.Notification && Notification.permission === 'granted') {
					createNot(str);
					console.log(str);
				} else if (window.Notification && Notification.permission !== 'denied') {
					Notification.requestPermission(function(status) {
						if(status ==='granted') {
							createNot(str);
						} else {
							alert("Notifications disabled. Users requested for registration.");
						}
					});
				} else {
					alert("Notifications disabled. Users requested for registration.");
				}
			} else{
				console.log(str);
			}
		}
	});
});

function createNot(data) {
	var notification = new Notification(data);
}

function messageSend() {
	stompClient.send('/app/checknotify',{}, "Send_Notification");
}