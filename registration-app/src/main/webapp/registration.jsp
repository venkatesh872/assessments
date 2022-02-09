<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
	<h1>Spring MVC App</h1>
	<pre>
	<form action="reg.do" method="post">
		UserName:<input type="text" name="username">
		Password:<input type="password" name="password">
		Confirm Password:<input type="password" name="confirmPassword">
		MobileNo:<input type="text" name="mobileNumber">
		Age:<input type="number" name="age">
		<input type="submit" value="Register">
		
	</form>
	</pre>
	<pre>
	<form action="login.do" method="post">
		UserName: <input type="text" name="username"> 
		Password: <input type="password" name="password"> 
		<input type="submit" value="login">
	</form>
	</pre>
	<pre>
	<form action="update.do" method="post">
		UserName: <input type="text" name="username"> 
		MobileNumber: <input type="text" name="mobileNumber"> 
		<input type="submit" value="update">
	</form>
	</pre>
	<pre>
	<form action="delete.do" method="post">
		UserName: <input type="text" name="username"> 
		MobileNumber: <input type="text" name="mobileNumber"> 
		Age:<input type="number" name="age">
		<input type="submit" value="delete">
	</form>
	</pre>
	
</body>
</html>
