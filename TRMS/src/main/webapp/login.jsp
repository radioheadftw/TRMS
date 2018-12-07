<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tuition Reimbursement Management System</title>
<style>
	body {
    	background-color: #D3DAE4;
	}
	
	h2 {
		text-align : center;
    	font-family: "Verdana";
	}
	h6 {
		text-align : center;
		font-family: "Verdana";
		color: red;
	}

	.text {
		width: 150px;
	}
	
	#div {
		position: absolute;
		right: 41.6%;
	}

	#login {
    	background-color: #6393DA;
    	border: none;
    	color: white;
    	padding: 2px 18px;
    	font-size: 16px;
    	cursor: pointer;
    	width: 75px; 
	}

	#login:hover {
    	background-color: #667FA4;
	}

	#form{
		width: 300px;
    	margin: 0 auto;
	}
	
</style>
</head>
<body>
	<h2>Tuition Reimbursement Management System</h2>
	<form action = "Login" method ="post" id="form">
		<table>
			<tr><td><label for = "username">Username</label>
			<td><input type ="text" class ="text" name = "username"/><br>
			<tr><td><label for = "password">Password</label>
			<td><input type = "password" class ="text" name = "password"/>
			<tr><td><div id="div"><button type="submit" value="Submit" id="login">Login</button></div>
		</table>
	</form>
	<h6>${message}</h6>	
</body>
</html>