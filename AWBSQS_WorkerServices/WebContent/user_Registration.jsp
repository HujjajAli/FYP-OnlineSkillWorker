<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.workerservices.daoImplement.Company_DAO_Implement"%>
<%@page import="com.workerservices.dao.Company_DAO"%>
<%@page import="com.workerservices.model.CountryData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
  Company_DAO cd = new Company_DAO_Implement();
  List<CountryData> countries = cd.getCountryData();
  request.setAttribute("countries", countries); 
  
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="css/register.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>User Registration</title>
</head>
<body>
	<div class="container" style="margin-bottom: 100px;">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">OSW</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<div class="form-group">
						<label for="ajaxadd" class="cols-sm-2 control-label">Set Location</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-globe fa"
									aria-hidden="true"></i></span> <button class="form-control" id="userAddress">Set My Location</button>
							</div>
						</div>
					</div>
				<form class="form-horizontal" method="post" action="RegistrationController">
				<input type="hidden" name="act" value="userRegistration">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="name" id="name" placeholder="Enter your Name" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="email" class="form-control" name="email" id="email"
									placeholder="Enter your Email" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker fa" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="password" id="password"
									placeholder="Enter Your Password" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="phone" class="cols-sm-2 control-label">Phone</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone fa"
									aria-hidden="true"></i></span> <input type="text"
									class="form-control" name="phone" id="phone"
									placeholder="Enter Your Phone" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="cnic" class="cols-sm-2 control-label">CNIC</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text"
									class="form-control" name="cnic" id="cnic"
									placeholder="Enter CNIC Number" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="dob" class="cols-sm-2 control-label">Date of
							Birth</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="date" class="form-control"
									name="dob" id="dob" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="country" class="cols-sm-2 control-label">Country</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-globe fa"
									aria-hidden="true"></i></span> 
								<select class="form-control" id="country" name="country">
									<option value="0">Select Country</option>
									<c:forEach items="${countries}" var="r">
									<option value="${r.id}">${r.country}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="city" class="cols-sm-2 control-label">City</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-globe fa"
									aria-hidden="true"></i></span> 
								<select class="form-control" id="city" name="city">
									<option value="0">First Select Your Country</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="area" class="cols-sm-2 control-label">Area/Home Address</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-globe fa"
									aria-hidden="true"></i></span> <input type="text"
									class="form-control" name="area" id="area"
									placeholder="Enter Your Area/Home Address" />
							</div>
						</div>
					</div>
					
					<div class="form-group text-center">
						<label for="gender" class="cols-sm-2 control-label">Gender</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<div style="margin: 50px;">
									<input type="radio" class="r1" name="gender" value="Male">
									Male <input type="radio" class="r2" name="gender"
										value="Female"> Female <input type="radio" class="r3"
										name="gender" value="other"> Other
								</div>
							</div>
						</div>
					</div>



					<div class="form-group ">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-button">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="ajaxjs/setAddressDataAjax.js"></script>
		<script type="text/javascript" src="ajaxjs/getAddressDataAjax.js"></script>
</body>
</html>