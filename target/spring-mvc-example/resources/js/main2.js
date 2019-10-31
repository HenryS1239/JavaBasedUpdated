'use strict';

const messaging = firebase.messaging();
const pushButton = document.querySelector('#notify');

//google
messaging.usePublicVapidKey("BA-iS8WcXpi3cr7IKWZvx901FFyTSwMClCyV7n81OwqQ8Me8BhjNMJ-Ugadz6_Rh9bQ0Hks5i151q0eimjKo5oI");

initApp();

function initApp(){
	navigator.serviceWorker.register('resources/js/sw.js',{ scope: '/Facebook/resources/js/'})
	.then((registration) => {
	  messaging.useServiceWorker(registration);
	
	  Notification.requestPermission().then((permission) => {
			if(permission === 'granted') {
				console.log('Notification permission granted.');
				pushButton.disabled = false;
			}else {
				console.log('Notification permission denied.');
			}
		});
	  //change this part to request token from app server
		messaging.getToken().then((currentToken) => {
			  if (currentToken) {
			    sendTokenToServer(currentToken);
			    console.log("Token sent.")
			  } else {
			    // Show permission request.
			    console.log('No Instance ID token available. Request permission to generate one.');
			    // Show permission UI.
			    pushButton.disabled = false;
			  }
			}).catch((err) => {
			  console.log('An error occurred while retrieving token. ', err);
			  showToken('Error retrieving Instance ID token. ', err);
			  pushButton.disabled = true;
			});
	
		messaging.onTokenRefresh(() => {
			  messaging.getToken().then((refreshedToken) => {
			    console.log('Token refreshed.');
			    // Indicate that the new Instance ID token has not yet been sent
				// to the
			    // app server.
			    // Send Instance ID token to app server.
			    sendTokenToServer(refreshedToken);
			    // ...
			  }).catch((err) => {
			    console.log('Unable to retrieve refreshed token ', err);
			    showToken('Unable to retrieve refreshed token ', err);
			  });
			});	
		//this whole part sandwiched bewtween both comments
	});
}


function showToken(currentToken) {
  // Show token in console and UI.
  const tokenElement = document.querySelector('#token');
  tokenElement.textContent = currentToken;
}

function sendTokenToServer(currentToken) {
	
    if (!isTokenSentToServer()) {
    	pushButton.disabled = true;
    	
    	console.log('Sending token to server...');
    	var xhr = new XMLHttpRequest();
    	xhr.open("POST", "/Facebook/token.html", true);
    	xhr.setRequestHeader('Accept', 'application/json');
    	xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

    	xhr.send(JSON.stringify(currentToken));
    	pushButton.disabled = false;
    } else {
      console.log('Token already sent to server so won\'t send it again ' +
          'unless it changes');
    }
    
  }
function isTokenSentToServer() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/Facebook/sent.html", true);
	xhr.send();
	xhr.onreadystatechange=function(){
		if(this.readystate==4 && this.readystate==200)
			return xhr.responseText;
		else
			return false;
	}
}


