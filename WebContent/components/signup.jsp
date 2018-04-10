<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/signup.js"></script>
</head>
<body>
	<div class="center">
		<button class="close-button" onclick="hideOverlay()">X</button>
		<div style="text-align: center;">
			Sign-up for Cravate
		</div>
		<br> 
		<form id="signup" action="Signup" method="POST">
			<label for="username">Username</label>
			<br> 
			<input type="text" id="signup-username" name="username" required/> 
			<br>
			<div class="error" id="signup-username-error"> </div>
			<br>
			<label for="password">Password</label>
			<br>
			<input type="password" id="signup-password" name="password" required/>
			<br>
			<div class="error" id="signup-password-error"> </div>
			<br>
			<label for="email">Email</label>
			<br>
			<input type="email" id="signup-email" name="email" required/>
			<br>
			<div class="error" id="signup-email-error"> </div>
			<br>
			<input type="submit" id="signup-submit" value="Sign-up" disabled=true>
		</form>
	</div>
</body>
</html>