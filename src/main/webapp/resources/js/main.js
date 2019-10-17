'use strict';

const applicationServerPublicKey = 'BAW1ODB_GtgE4ZLrGdtUtnuQWggxW4_KTlORtYyXXMQ3Sv1IqH7TFNjRjGvMQX-gHXFOVe6yFZRpuhMO6oyj6lQ';
// find a way to generate own public key for use

const pushButton = document.querySelector('#notBtn')
// change id to corresponding id in jsp

let isSubscribed = false;
let swRegistration = null;

if ('serviceWorker' in navigator && 'PushManager' in window) {
  console.log('Service Worker and Push is supported');


  navigator.serviceWorker.register('resources/js/sw.js',{ scope: '/Facebook/resources/js/' })
  .then(function(swReg) {
    console.log('Service Worker is registered', swReg);

    swRegistration = swReg;
    initializeUI();
  
  })
  
  .catch(function(error) {
    console.error('Service Worker Error', error);
  });
  
  } else {
    console.warn('Push messaging is not supported');
    // pushButton.disabled = true;
    // omit?
}

function initializeUI() {

  // Set the initial subscription value
  swRegistration.pushManager.getSubscription().then(function (subscription) {
    isSubscribed = !(subscription == null);

    if (isSubscribed) {
      console.log('User IS subscribed.');
    } else {
      console.log('User is NOT subscribed.');
    }

  });

  if (isSubscribed) {
    unsubscribeUser();
  } else {
    subscribeUser();
  }
}



function subscribeUser() {
  const applicationServerKey = urlB64ToUint8Array(applicationServerPublicKey);
  swRegistration.pushManager.subscribe({
    userVisibleOnly: true,
    applicationServerKey: applicationServerKey
  })
  .then(function(subscription) {
    console.log('User is subscribed.');



    isSubscribed = true;

    // updateBtn();
  })
  .catch(function(err) {
    console.log('Failed to subscribe the user: ', err);
    // updateBtn();
  });
}


function unsubscribeUser() {
  swRegistration.pushManager.getSubscription()  
  .then(function(subscription) {
    if (subscription) {
      return subscription.unsubscribe();
    }
  })
  .catch(function(error) {
    console.log('Error unsubscribing', error);
  })
  .then(function() {
   

    console.log('User is unsubscribed.');
    isSubscribed = false;

    // updateBtn();
  })
}

function urlB64ToUint8Array(base64String) {
  const padding = '='.repeat((4 - base64String.length % 4) % 4);
  const base64 = (base64String + padding)
    .replace(/\-/g, '+')
    .replace(/_/g, '/');

  const rawData = window.atob(base64);
  const outputArray = new Uint8Array(rawData.length);

  for (let i = 0; i < rawData.length; ++i) {
    outputArray[i] = rawData.charCodeAt(i);
  }
  return outputArray;
}
