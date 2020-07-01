<%@page import="com.workerservices.daoImplement.Company_DAO_Implement"%>
<%@page import="com.workerservices.dao.Company_DAO"%>
<%@page import="com.workerservices.model.CityData"%>
<%@page import="com.workerservices.model.Customer"%>
<%@page import="com.workerservices.daoImplement.Customer_DAO_Implement"%>
<%@page import="com.workerservices.dao.Customer_DAO"%>
<%@page import="com.workerservices.model.CustomerAddress"%>
<%@page import="com.workerservices.model.Worker"%>
<%@page import="com.workerservices.daoImplement.Worker_DAO_Implement"%>
<%@page import="com.workerservices.dao.Worker_DAO"%>
<%@page import="java.util.List"%>
<%@page import="com.workerservices.model.WorkOrders"%>
<%@page import="com.workerservices.dao.WorkOrderDAO"%>
<%@page import="com.workerservices.daoImplement.WorkOrderDAO_Implement"%>
<%@page import="com.workerservices.model.WorkerAddress"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Worker - Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="worker_mobile_ui/mobile_ui.css">
<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<script src="worker_mobile_ui/mobile_ui_JS.js"></script>
<!-- Bootstrap -->
<link href='css/bootstrap.min.css' rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.bg-mynav {
	box-shadow: 0px 10px 10px rgba(0, 0, 0, .3);
	background-image: linear-gradient(109.6deg, rgba(119, 44, 232, 1) 11.5%,
		rgba(119, 44, 232, 1) 91.2%);
}

#map {
	height: 250px;
	width: 100%;
}
</style>

<%
	if(session.getAttribute("wkr") == null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}else{
		
	}
	WorkOrderDAO orderDAO = new WorkOrderDAO_Implement();
	Worker_DAO workerDAO = new Worker_DAO_Implement();
	Customer_DAO customerDAO = new Customer_DAO_Implement();
	Company_DAO cdao = new Company_DAO_Implement();

	Worker worker = (Worker)session.getAttribute("wkr");
	List<WorkOrders> orders = orderDAO.getOrdersByWorkerID(worker.getId());
	WorkerAddress wadd = worker.getAddress();
	

	request.setAttribute("workeraddress", wadd);
	request.setAttribute("wkr", worker);
	request.setAttribute("pandingOrders", orders);
	//request.setAttribute("cusAdd", cusadd);
	int count = 1;
	CityData city = cdao.getCityById(1);
%>
</head>
<body>

	<div id="splash" style="display: none;">
		<!--	<img class="logo" src="https://i.ibb.co/G5jyXN9/logo.png" alt="" /> -->
	</div>
	<div class="content">
		<header class="app-header bg-mynav">
		<div class="container">
			<!--<img class="logo" src="https://i.ibb.co/G5jyXN9/logo.png" alt="" />-->
			<h4>
				<p class="logo">
					<c:out value="${wkr.worker}"></c:out><br>
					<% //out.print("Path :"+ application.getInitParameter("imagesPath")); %>
				</p>
			</h4>
			<input class="search" name="search" type="text"
				placeholder="Search..." />
		</div>
		</header>

		<div class="subheader">
			<div>
				<p>Now delivering Rx + more</p>
				<p>
					Find out now <i class="fa fa-chevron-right"></i>
				</p>
			</div>
			<img src="https://i.ibb.co/PxGygfW/delivery.png" alt="" />
		</div>

		<div id="pendingorders" class="container">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>Customer</th>
					<th>Order Time</th>
					<th>Order Date</th>
					<th>Order Status</th>
					<th>Action</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${pandingOrders}" var="r">
					<tr>
						<td><c:out value="${r.costumer.customer}"></c:out></td>
						<td><c:out value="${r.time}"></c:out></td>
						<td><c:out value="${r.date}"></c:out></td>
						<td><c:out value="${r.orderStatus}"></c:out></td>
						<td><button onclick='completeOrder(<c:out value="${r.id}"></c:out>,<c:out value="${r.worker.id}"></c:out>)' class="btn btn-success">Complete</button></td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
					<center><button data-toggle="modal" data-target="#mod" class="btn btn-success">View Locations</button></center>
				</tfoot>
			</table>
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
	
	<%for(WorkOrders wo:orders){
	 Customer customer = wo.getCostumer(); 
	 CustomerAddress cusadd = customer.getAddress(); }%>
	<div id="mod" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Customer Locations</h4>
				</div>
				<div class="modal-body">
					<div style="height:250px; width:100%" id="map" class="modal-footer ">
				</div>
				
				<h5>Map</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- map Code -->
	<%//for(WorkOrders wo:orders){ 
		//Customer customer = wo.getCostumer(); 
	    //CustomerAddress cusadd = customer.getAddress();}%>
	<script>
	<%for(WorkOrders wo:orders){
	Customer customer = wo.getCostumer(); 
	    CustomerAddress cusadd = customer.getAddress(); %>
	    
	console.log("<%out.print(customer.getCustomer());%>");
	console.log("<%out.print(cusadd.getLatitude());%>");
	console.log("<%out.print(cusadd.getLongitude());%>");
   <%}%>
	
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: <%out.print(city.getLatitude());%>, lng: <%out.print(city.getLongitude());%>},
          zoom: 11
        });
        <%for(WorkOrders wo:orders){
         Customer customer = wo.getCostumer(); 
	    CustomerAddress cusadd = customer.getAddress(); %>
        marker  = new google.maps.Marker({
			position : {lat: <%out.print(cusadd.getLatitude());%>, lng: <%out.print(cusadd.getLongitude());%>},
			title    : "<%out.print(customer.getCustomer());%>"
		});
        marker.setMap(map);
        <%}%>
      }
      
      
      function completeOrder(oID,wID){
    	  console.log("ORDER :"+oID);
    	  console.log("Worker :"+wID);
    	  
    	  $.ajax({url: "OrderControllerAjax?oID="+oID+"&wID="+wID,success: function(r){
    			console.log(r);
    			$("#pendingorders").html(r);
    	}});
      }
      
    </script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBud-B2VEB2MFSVUig2ykXvz7nISkc27PM&callback=initMap"
		async defer></script>
	<!-- map Code-->
	
</body>
</html>