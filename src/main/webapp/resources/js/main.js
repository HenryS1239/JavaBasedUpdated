'use strict';
var notifyButton = document.querySelector('#notify');
var token = null;

window.addEventListener('load', function() {
	// At first, let's check if we have permission for notification
	// If not, let's ask for it
	var temp = localStorage.getItem("token");
	if(temp != null)
		token = temp;
	
	 Notification.requestPermission().then((permission) => {
			if(permission === 'granted') {
				console.log('Notification permission granted.');
				notifyButton.disabled = false;
			}else {
				console.log('Notification permission denied.');
			}
		});

	if (token == null) {
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/Facebook/reqtoken.html", true);
		xhr.setRequestHeader('Accept', 'text/html');
		xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
		xhr.send();
		xhr.onreadystatechange=function(){
			token = xhr.responseText;
			console.log(token);
			localStorage.setItem("token", token);
		}
	}
	
	if(requestNotification()){
		createNotification();
	}

});

function requestNotification(){
	console.log('Requesting for Notification');
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/Facebook/checknotify.html", true);
	xhr.send(token);
	xhr.onreadystatechange=function(){
		if(this.readystate==4 && this.readystate==200)
			if(xhr.responseText != "") {
				console.log("Response Received.");
				return true;
			}
		else{
			console.log("Response NOT Received.")
			return false;
	
		}
	}	
}

function createNotification() {
	if (window.Notification && Notification.permission === "granted") {
		var notification = new Notification('Match found. Click for more details.');
		notification.addEventListener('click', function() {
			window.open("localhost:8080/Facebook/doUpdate.html");
		});
	} else if (window.Notification && Notification.permission !== "denied") {
		Notification.requestPermission(function(status) {
			// If the user said okay
			if (status === "granted") {
				var notification = new Notification('Match found. Click for more details.');
				notification.addEventListener('click', function() {
					window.open("localhost:8080/Facebook/doUpdate.html");
				});
			} else {
				alert("Notifications disabled. Unable to show notification.");
			}
		});
	} else {
		alert("Notifications disabled. Unable to show notification.");
	}
}
