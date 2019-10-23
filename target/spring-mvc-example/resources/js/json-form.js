const pushForm = document.getElementById("push-form-json");
const userForm = document.getElementById("user-form-json");

const button = document.getElementById(".button");
var xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
    if (this.readyState == 4 && this.readyState == 200) {
    	console.log(xhr.responseText);
        window.location.replace(xhr.responseText);
    }
}


if (pushForm != null){
	pushForm.addEventListener('submit', function(event){
		event.preventDefault();
		var formData = new FormData(pushForm),
		   result = {};
		for (var entry of formData.entries())
		{
		   result[entry[0]] = entry[1];
		}
		result = JSON.stringify(result)
		
		xhr.open("POST", "/Facebook/notify.html", true);
		xhr.setRequestHeader('Accept', 'application/json');
		xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
		xhr.send(result);
		

		console.log("Function done");
		
	});
}
else if (userForm != null){
	userForm.addEventListener('submit', function(event){
		event.preventDefault();
		var formData = new FormData(userForm),
		   result = {};
		for (var entry of formData.entries())
		{
		   result[entry[0]] = entry[1];
		}
		result = JSON.stringify(result)
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/Facebook/notify.html", true);
		xhr.setRequestHeader('Accept', 'application/json');
		xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
		xhr.send(result);
		
		console.log("Function done");
		
	});
}