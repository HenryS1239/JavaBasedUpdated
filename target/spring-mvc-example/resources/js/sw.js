'use strict';

self.addEventListener('push', function(event) {
	console.log('[Service Worker] Push Received.');
	console.log(`[Service Worker] Push had this data: "${event.data.text()}"`); //(``) and ('') are different

	const title = 'Push CodeLab';
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
