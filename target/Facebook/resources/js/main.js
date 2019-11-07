'use strict';
var notifyButton = document.querySelector('#notify');
var logoutButton = document.querySelector('#logout');
var token = null;

logoutButton.addEventListener('click', function(event){
	console.log('Deleting token');
	sessionStorage.removeItem('token');
});

window.addEventListener('load', function() {
	// At first, let's check if we have permission for notification
	// If not, let's ask for it
	var temp = sessionStorage.getItem("token");
	if(temp != null)
		token = temp;
	
	 Notification.requestPermission().then((permission) => {
			if(permission === 'granted') {
				notifyButton.disabled = false;
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
			sessionStorage.setItem("token", token);
		}
	} else{
		requestNotification();
	}
	
	
});	

function requestNotification(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			if(xhr.responseText == "Notification Found") {
				createNotification();
				return true;
			} else {
				return false;
			}	
		}
	}
	console.log('Requesting for Notification');
	xhr.open("POST", "/Facebook/checknotify.html", true);
	xhr.send(token);
}

function createNotification() {
	console.log("creating Notification");
	if (window.Notification && Notification.permission === "granted") {
		var notification = new Notification('Match found. Click for more details.');
		notification.addEventListener('click', function() {
			window.open("notification.html","_blank");
		});
	} else if (window.Notification && Notification.permission !== "denied") {
		Notification.requestPermission(function(status) {
			// If the user said okay
			if (status === "granted") {
				var notification = new Notification('Match found. Click for more details.');
				notification.addEventListener('click', function() {
					window.open("notification.html","_blank");
				});
			} else {
				alert("Notifications disabled. Unable to show notification.");
			}
		});
	} else {
		alert("Notifications disabled. Unable to show notification.");
	}
}
