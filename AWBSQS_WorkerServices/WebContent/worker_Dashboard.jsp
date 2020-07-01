<%@page import="com.workerservices.model.Worker"%>
<%@page import="com.workerservices.model.WorkerAddress"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% if(session.getAttribute("wkr")==null){
	request.getRequestDispatcher("").forward(request, response);
} %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Worker - Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link  rel="stylesheet" href="worker_mobile_ui/mobile_ui.css"> 
<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <script src="worker_mobile_ui/mobile_ui_JS.js"></script>  

<style>
 .bg-mynav
{
	box-shadow:0px 10px 10px rgba(0, 0, 0, .3);
	
	background-image: linear-gradient( 109.6deg,  rgba(119,44,232,1) 11.5%, rgba(119,44,232,1) 91.2% );
}


</style>

<%
Worker wkr = (Worker)session.getAttribute("wkr");
request.setAttribute("wkr", wkr);
WorkerAddress wadd = (WorkerAddress)request.getAttribute("workeraddress"); 

%>
</head>
<body>

<div id="splash" style="display: none;">
			<img class="logo" src="https://i.ibb.co/G5jyXN9/logo.png" alt="" />
		</div>
		<div class="content">
			<header class="app-header bg-mynav">
				<div class="container">
					<!-- <img class="logo" src="https://img.icons8.com/nolan/100/work.png" alt="" />-->
					<p class="logo"><h3>${wkr.worker}</h3></p>
					<input class="search" type="text" placeholder="Search..." />
				</div>
			</header>

			<div class="subheader">
				<div>
					<p>Now delivering Rx + more</p>
					<p>Find out now <i class="fa fa-chevron-right"></i></p>
				</div>
				<img src="https://i.ibb.co/PxGygfW/delivery.png" alt="" />
			</div>

			<div class="grid container">
				<a href="worker_PandingOrders.jsp"><div class="item">
					<h4>Panding Work</h4>
					<p class="desc">Remaining Orders for You</p>
					<img src="https://img.icons8.com/bubbles/100/000000/work.png" alt="" />
				</div></a>
				<div class="item">
					<h4>Fulfilled Work</h4>
					<p class="desc">Orders Already Fulfilled by You</p>
					<img src="https://i.ibb.co/XY6WTq6/medal.png" alt="" />
				</div>
				<div class="item">
					<h4>My Company</h4>
					<p class="desc"></p>
					<img src="https://img.icons8.com/nolan/64/company.png" alt="" />
				</div>
				<div class="item">
					<h4>My Account</h4>
					<p class="desc">View Detail Profile </p>
					<img src="https://img.icons8.com/plasticine/100/000000/guest-male.png" alt="" />
				</div>
				<div class="item">
					<h4>Payments</h4>
					<p class="desc"></p>
					<img src="https://img.icons8.com/dusk/64/000000/online-payment-.png" alt="" />
				</div>
				<div class="item">
					<h4>History</h4>
					<p class="desc">View your work History</p>
					<img src="https://img.icons8.com/wired/64/000000/order-history.png" alt="" />
				</div>
			</div>
		</div>

		<footer class="app-footer bg-mynav">
			<ul>
				<li><a href="worker_Dashboard.jsp" style="color:red;"><i class="fa fa-heart"></i> Home</a></li>
				<li><a href="#" style="color:red;"><i class="fa fa-barcode"></i>Payments </a></li> 
				<li><a href="LogoutController" style="color:red;"><i class="fa fa-user"></i> Logout</a></li>
				<li><a href="#" style="color:red;"><i class="fa fa-map-marker"></i> My Company</a></li>
			</ul>
	   </footer>


</body>
</html>