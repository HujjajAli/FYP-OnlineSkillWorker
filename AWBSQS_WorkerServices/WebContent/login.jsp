<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
 if(session.getAttribute("login_customer")==null){ }else{
	 request.getRequestDispatcher("index.jsp").forward(request, response);
 }

 if(session.getAttribute("wkr")==null){}else{
	 request.getRequestDispatcher("worker_Dashboard.jsp").forward(request, response);
 }
 
 if(session.getAttribute("company")==null){}else{
	 request.getRequestDispatcher("company_Dashboard.jsp").forward(request, response);
 }
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/loginform.css">
<title>Login Page</title>

</head>
<body>
	<div class="wrapper fadeInDown mt-5">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="img/profile.png" id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form action="LoginController" method="POST">
				<input type="text" id="email" class="fadeIn second" name="email"
					placeholder="Enter Email"> <input type="text" id="password"
					class="fadeIn third" name="password" placeholder="Enter Password"> <input
					type="submit" class="fadeIn fourth" value="Log In">
					<select name="login_user" >
						<option value="member">Member</option>
						<option value="worker">Worker</option>
						<option value="company">Company</option>
					</select>
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="worker_Registration.jsp">Sign Up As Worker</a><br>
				<a class="underlineHover" href="user_Registration.jsp">Sign Up As Customer</a><br>
				<a class="underlineHover" href="company_Registration.jsp">Sign Up As Company</a>
			</div>

		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>