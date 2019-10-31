/*'use strict';

var websock = new WebSocket("ws://localhost:8080/msgtunnel");

var token = null;

var notifyButton = document.querySelector('#notify');

window.addEventListener('load', function() {
	// At first, let's check if we have permission for notification
	// If not, let's ask for it
	if (window.Notification && Notification.permission !== "granted") {
		Notification.requestPermission(function(status) {
			if (Notification.permission !== status) {
				Notification.permission = status;
			}
		});
	}

	if (token == null) {
		websock.onmessage = function(message) {
			var ServerMsg = message;
			if (ServerMsg.slice(0, 12) == "Client Found") {
				websock.send("Request Client");
			} else if (ServerMsg.slice(0, 13) == "List of Tokens") {
				var tokens = ServerMsg.slice(14);
				if (!(tokens.search(token) == -1))
					websock.send("Request Notification");
			} else if (ServerMsg.slice(0, 12) == "Notification") {
				createNotification(ServerMsg);
			}
		}
	}

});

notifyButton.addEventListener('click', function() {
	formData.append('token', token);
});

websock.onmessage = function(message) {
	var ServerMsg = message;
	if (ServerMsg.slice(0, 12) == "Client Found") {
		websock.send("Request Client.");
	} else if (ServerMsg.slice(0, 13) == "List of Tokens") {
		var tokens = ServerMsg.slice(14);
		if (!(tokens.search(token) == -1))
			websock.send("Request Notification.");
	} else if (ServerMsg.slice(0, 12) == "Notification") {
		createNotification(ServerMsg);
	} else if (ServerMsg.slice(0, 5) == "Token") {
		token = ServerMsg.slice(6);
	}
}

function createNotification(msg) {
	if (window.Notification && Notification.permission === "granted") {
		var notification = new Notification(msg.slice(13));
		notification.addEventListener('click', function() {
			window.open("localhost:8080/Facebook/doUpdate.html");
		});
	} else if (window.Notification && Notification.permission !== "denied") {
		Notification.requestPermission(function(status) {
			// If the user said okay
			if (status === "granted") {
				var notification = new Notification(msg.slice(13));
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
*/