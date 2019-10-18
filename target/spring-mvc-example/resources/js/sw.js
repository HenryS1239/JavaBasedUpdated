'use strict';

importScripts('https://www.gstatic.com/firebasejs/6.3.4/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/6.3.4/firebase-messaging.js');
// Initialize the Firebase app in the service worker by passing in the
// messagingSenderId.
firebase.initializeApp({
  'messagingSenderId': 'YOUR-SENDER-ID'
});
// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging();

self.addEventListener('push', function(event) {
	console.log('[Service Worker] Push Received.');
	console.log(`[Service Worker] Push had this data: "${event.data.text()}"`); //(``) and ('') are different
	
	  const title = 'Push Codelab';
	  const options = {
	    body: 'Yay it works.',
	    icon: 'images/icon.png',
	    badge: 'images/badge.png'
	  };
	
	const notificationPromise = self.registration.showNotification(title, options);
	event.waitUntil(notificationPromise);
	//event.waitUntil(self.registration.showNotification(title, options));  same as above 2 lines of code
});

self.addEventListener('notificationclick', function(event) {
	
  console.log('[Service Worker] Notification click Received.');

  event.notification.close();

  event.waitUntil(
    clients.openWindow('https://duckduckgo.com/')
  );
});

