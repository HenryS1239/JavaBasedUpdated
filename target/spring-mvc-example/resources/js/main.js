'use strict';

const messaging = firebase.messaging();

messaging.usePublicVapidKey("BA-iS8WcXpi3cr7IKWZvx901FFyTSwMClCyV7n81OwqQ8Me8BhjNMJ-Ugadz6_Rh9bQ0Hks5i151q0eimjKo5oI");

initApp();

function initApp(){
	navigator.serviceWorker.register('resources/js/sw.js',{ scope: '/Facebook/resources/js/'})
	.then((registration) => {
	  messaging.useServiceWorker(registration);
	
	  Notification.requestPermission().then((permission) => {
			if(permission === 'granted') {
				console.log('Notification permission granted.');
			}else {
				console.log('Notification permission denied.');
			}
		});
	
		messaging.getToken().then((currentToken) => {
			  if (currentToken) {
			    sendTokenToServer(currentToken);
			     
			  } else {
			    // Show permission request.
			    console.log('No Instance ID token available. Request permission to generate one.');
			    // Show permission UI.
			    updateUIForPushPermissionRequired();
			    setTokenSentToServer(false);
			  }
			}).catch((err) => {
			  console.log('An error occurred while retrieving token. ', err);
			  showToken('Error retrieving Instance ID token. ', err);
			  setTokenSentToServer(false);
			});
	
		messaging.onTokenRefresh(() => {
			  messaging.getToken().then((refreshedToken) => {
			    console.log('Token refreshed.');
			    // Indicate that the new Instance ID token has not yet been sent to the
			    // app server.
			    setTokenSentToServer(false);
			    // Send Instance ID token to app server.
			    sendTokenToServer(refreshedToken);
			    // ...
			  }).catch((err) => {
			    console.log('Unable to retrieve refreshed token ', err);
			    showToken('Unable to retrieve refreshed token ', err);
			  });
			});	
	});
}

function sendTokenToServer(currentToken) {
    if (!isTokenSentToServer()) {
      console.log('Sending token to server...');
      // TODO(developer): Send the current token to your server.
      setTokenSentToServer(true);
    } else {
      console.log('Token already sent to server so won\'t send it again ' +
          'unless it changes');
    }
  }

function isTokenSentToServer() {
    return window.localStorage.getItem('sentToServer') === '1';
  }

function setTokenSentToServer(sent) {
    window.localStorage.setItem('sentToServer', sent ? '1' : '0');
  }


function showToken(currentToken) {
  // Show token in console and UI.
  const tokenElement = document.querySelector('#token');
  tokenElement.textContent = currentToken;
}

