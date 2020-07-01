<%@page import="com.workerservices.dao.WorkOrderDAO"%>
<%@page import="com.workerservices.daoImplement.WorkOrderDAO_Implement"%>
<%@page import="com.workerservices.model.WorkOrders"%>
<%@page import="com.workerservices.daoImplement.Worker_DAO_Implement"%>
<%@page import="com.workerservices.dao.Worker_DAO"%>
<%@page import="com.workerservices.model.Worker"%>
<%@page import="com.workerservices.model.Customer"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

	
	Worker_DAO wdao  = new Worker_DAO_Implement();
	WorkOrderDAO workorderdao = new WorkOrderDAO_Implement();
    List<Worker> workerData; // //wdao.getVarifiedWorkers();
    
    
    Customer cus = new Customer();
    
    String hireBTN = "na";
    if(session.getAttribute("login_customer")==null){
    	hireBTN =  "status_guest";
    	workerData = wdao.getVarifiedWorkers();
    	request.setAttribute("workers", workerData);
    }else{
    	hireBTN =  "status_login";
        cus = (Customer)session.getAttribute("login_customer");
        workerData = wdao.getAllunbookedWorkers(cus.getId());
        request.setAttribute("workers", workerData);
    }
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<title>Welcome Index</title>
</head>
<body>
	<jsp:include page="user_Navbar.jsp"></jsp:include>
	

	<!--slider Ad starts-->
	<div id="carouselExampleControls" class="carousel slide mt-5"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/s4.jpg" class="d-block w-100" alt="s1">
				<div class="carousel-caption">
					<h3>Los Angeles</h3>
					<p>We had such a great time in LA!</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/s5.jpg" class="d-block w-100" alt="s2">
				<div class="carousel-caption">
					<h3>Los Angeles</h3>
					<p>We had such a great time in LA!</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/s6.jpg" class="d-block w-100" alt="s3">
				<div class="carousel-caption">
					<h3>Los Angeles</h3>
					<p>We had such a great time in LA!</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleControls"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!--slider Ad Ends-->


	<!--worker cards Starts-->
	<div class="container-fluid">
		<div class="jumbotron mt-5 parallax2 text-center">
			<h1 style="color:white;">Workers</h1>
		</div>
		<div class="row">
		<!-- db data strt -->
				<%for(Worker w:workerData){ %>
			<div class="col-sm-4">
				
					<!--Card Starts-->
					<div class="card-panel row">
						<div class="card-img col-sm-6">
							<img src="img/profile.png" class="card-img-top mt-4" height="206"
								alt="saeed">
						</div>
						<div class="wrraper col-sm-6">
							<div class="card-title">
								<h1 class="title">
									<%out.print(w.getWorker()); %>
								</h1>
							</div>
							<div class="card-price">
								<h1 class="price">
									<%out.print(w.getTrade().getTrade()); %>
								</h1>
							</div>
							<div class="card-desc">
								<p class="desc">
									<%out.print(w.getAddress().getCountry()+","+w.getAddress().getCity()); %>
								</p>
							</div>
							<div class="card-desc">
								<p class="desc">
								<strong>Rating <%out.print(w.getRating()) ;%>/10.0</strong>
								</p>
							</div>
							<div class="card-btn">
								<button class="button1" data-toggle="modal" data-target="#<%out.print(hireBTN+w.getId()); %>">Hire Worker</button>
							</div>
						</div>
					</div>
					<!--Card Ends-->
			</div>
			<%} %>
			<!-- code up -->
					
		</div>
	</div>
	<!--worker cards Ends-->
	
	
	<!-- Models for Confirming State -->
		<!-- Model for Guest -->
		<%for(Worker w:workerData){ %>
		<div class="modal fade" id="status_guest<%out.print(w.getId());%>" role="dialog">
			<div class="modal-dialog">
			

				<!-- Modal content --> 
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">You Have to Login First</h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<a href="login.jsp"  class="btn btn-success btn-lg">Login Here</a>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<%} %>
		<!-- Model for Guest -->
		
		<!-- Model for Login User -->
		<%for(Worker w:workerData){ %>
		<div class="modal fade" id="status_login<%out.print(w.getId()); %>" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content --> 
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Hire  <%out.print(w.getWorker());%></h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div id="workerhired" class="modal-body">
						
						
						<br>
						<!-- Laste Minute Code start --> 
						<div class="form-horizontal">
						
						<div class="form-group">
							  <label class="control-label col-sm-2" for="availbilitydate">Select Date:</label>
							  <div class="col-sm-10">
							 	<input type="date" id="availbilitydate"  class="form-control">
							  </div>
						</div>
						<div class="form-group">
									<label class="control-label col-sm-1" for="frmhour">From  Hours</label>
								 	<div class="col-sm-5">
										<select class="form-control" id="frmhour"><%for(int i=1;i<=12;i++){out.print("<option value='"+i+"'>"+i+"</option>");} %></select>
									</div>
									<label class="control-label col-sm-1" for="frmMinutes">From  Minutes</label>
									<div class="col-sm-5">
										<select class="form-control" id="frmMinutes"><%for(int i=0;i<60;i+=30){out.print("<option value='"+i+"'>"+i+"</option>");} %></select>
									</div>
						</div>			
									
						<div class="form-group">
							<label class="control-label col-sm-1" for="Tohour">To Hours</label>
							   <div class="col-sm-5">
									<select class="form-control" id="Tohour"><%for(int i=1;i<=12;i++){out.print("<option value='"+i+"'>"+i+"</option>");} %></select>
							   </div>
							<label class="control-label col-sm-1" for="ToMinutes">To Minutes</label>
							   <div class="col-sm-5">   
		                			<select class="form-control" id="ToMinutes"><%for(int i=0;i<60;i+=30){out.print("<option value='"+i+"'>"+i+"</option>");} %></select>
		                       </div>
		                </div>
		                
						</div>
						<button onclick="hireworker(<%out.print(w.getId()); %>,<%out.print(cus.getId());%>,availbilitydate,frmhour,frmMinutes,Tohour,ToMinutes)"  class="btn btn-success btn-lg" disable="true">Hire Him</button><br>
					<!-- 	<button onclick="checkworkeravailibility(availbilitydate,frmhour,frmMinutes,Tohour,ToMinutes,<%//out.print(w.getId()); %>,<%//out.print(cus.getId());%>)" id="AvailibitySearch">Search</button>-->
						<table class="table">
							<tr>
								<th>Date</th>
								<th>From</th>
								<th>to</th>
								<th>Status</th>
							</tr>
							<%
							List<WorkOrders> orders = workorderdao.getOrdersByWorkerID(w.getId());
							for(WorkOrders wo:orders){ %>
								<tr>
								<td><%out.print(wo.getPWODate()); %></td>
								<td><%out.print(wo.getPWOFromTime()); %></td>
								<td><%out.print(wo.getPWOToTime()); %></td>
								<td>Booked</td>
							</tr>
							<%} %>
						</table>
						<%List<WorkOrders> reviews = workorderdao.getGetReviewsByWorkerId(w.getId());
						  for(WorkOrders wo:reviews){%>
							<div class="well well-sm"><%out.print(wo.getReview()); %> <br><br><span class="label label-danger">Posted By : <%out.print(wo.getCostumer().getCustomer()); %></span></div>
						<%}%>
						
						<!-- Laste Minute Code start -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<%} %>
		<!-- Model for Login User --> 
		
		<!-- Models for Confirming State -->

    <!-- Footer -->
	<jsp:include page="user_Footer.jsp"></jsp:include>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="ajaxjs/hireworkerajax.js"></script>
		<script type="text/javascript" src="ajaxjs/AvailibitySearch.js"></script>
</body>
</html>