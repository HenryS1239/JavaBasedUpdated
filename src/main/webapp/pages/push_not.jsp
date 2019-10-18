<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="login_success_title"/></title>
    <style>
    	.button {
			  background-color: green;
			  border: none;
			  color: white;
			  padding: 10px 15px;
			  margin-top: 10	px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 15px;
			  margin: 15px 8px;
			  cursor: pointer;
		}
    </style>
</head>

<body>

    <h1>Get Notified </h1>

    <form action="${pageContext.request.contextPath}/notify.html" method="post" class="notify">
    
        <div class="box">
            <label for="userid">User ID: </label><br/>
            <input type="text" id="userid" name="userid" class="userid" /><br/> 
            <label for="userid">Group ID: </label><br/>
            <input type="text" id="groupid" name="groupid" class="userid" /><br/>
        
            <label for="sentinel">Transaction type: </label><br/>
            <input type="text" id="clientT" placeholder="{Account Number}"><br/>
            <label for="sentinel">Value: </label><br/>
            <input type="text" id="value" placeholder="Value:RMXX.XX; Time:XXXX"><br/>

            <label for="userid">Custom Message:</label><br/>
            <textarea rows="4" cols="50" id="customMsg"></textarea><br/>

            <div><input type="submit" class="button" value="Notify Me" /></div>

        </div>

    </form>

</body>

<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/7.2.1/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/7.2.1/firebase-messaging.js"></script>

<script>
  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyBITHGVy77Drl-DjkJNvKNuzt-jX2-9pIA",
    authDomain: "pushnotification-ff078.firebaseapp.com",
    databaseURL: "https://pushnotification-ff078.firebaseio.com",
    projectId: "pushnotification-ff078",
    storageBucket: "pushnotification-ff078.appspot.com",
    messagingSenderId: "708440050320",
    appId: "1:708440050320:web:0bc2bbf55655c5079a2615"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
</script>

<script defer src="<%=request.getContextPath() %>/resources/js/main.js"></script>

<script>
const dataToSend = JSON.stringify({"email": "hey@mail.com", "password": "101010"});
let dataRecieved=""; 
fetch("",{credentials:'same-origin',mode:'same-origin',method:"post",body:dataToSend})
              .then(resp => {
                if(resp.status==200){
                   return resp.json()
                }else{
                    console.log("Status: "+resp.status);
                    return Promise.reject("server")
                }
              })
           .then(dataJson =>{
                 dataToRecieved = JSON.parse(dataJson);
             })
              .catch(err =>{
                if(err=="server")return
                console.log(err);
            })
            
</script>

</html>