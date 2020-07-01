<%@page import="com.workerservices.daoImplement.Worker_DAO_Implement"%>
<%@page import="com.workerservices.dao.Worker_DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.workerservices.model.Worker"%>
<%@page import="java.util.List"%>
<%@page import="com.workerservices.model.Company"%>
<%@page import="com.workerservices.daoImplement.Company_DAO_Implement"%>
<%@page import="com.workerservices.dao.Company_DAO"%>
<%@page import="com.workerservices.model.CityData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

	if(request.getSession().getAttribute("company")==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
  Company_DAO cdao = new Company_DAO_Implement();
  Worker_DAO wd        = new Worker_DAO_Implement();
  Company c        = (Company)request.getSession().getAttribute("company");
  CityData city = cdao.getCityById(1);
  
    List<Integer> verifiedWorkers = cdao.getVarifiedWorkers(c.getId());
	List<Worker> companyWorker = new ArrayList<Worker>();
	for (Integer integer : verifiedWorkers) {
		Worker worker;
		worker = wd.getWorkerById(integer);
		companyWorker.add(worker);
	}
	
	request.setAttribute("companyWorkers", companyWorker);
	request.setAttribute("workersRequests", cdao.getWorkerRequests(c.getTrade().getId()));
  
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company - Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/loggedin.css">
<link href='css/bootstrap.min.css' rel='stylesheet'>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
	<style>
	#map {
        height: 100%;
        width: 100%;
      }

	</style>
<body>
	<jsp:include page="worker_Navbar.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="col-md-3">
			<ul class="navbar text-center nav dash" style="height: 145vh">
				<div style="color: white; margin-top: 50px; margin-bottom: 80px;">
					<img src="img/profile.png" alt="profile" height="70" width="70"
						style="border-radius: 50%; margin-bottom: 20px;">
					<p><%=c.getCompany() %></p>
				</div>
				<li><a href="company_Dashboard.jsp"><span
						class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
				<li><a href="#new" data-toggle="collapse"><span
						class="glyphicon glyphicon-plus"></span> Worker</a>
					<ul class="nav collapse" id="new">
						<li><a href="#"><div class="col-md-1"></div>
								<span class="glyphicon glyphicon-pencil"></span>Workers Requests</a></li>
						<li><a href="company_Workers.jsp"><div class="col-md-1"></div>
								<span class="glyphicon glyphicon-edit"></span> Approved Workers</a></li>
					</ul></li>

				<li><a href="#"><span
						class="glyphicon glyphicon-list"></span> Orders</a></li>
				<li><a href="#"><span
						class="glyphicon glyphicon-tasks"></span> Categories</a></li>
			</ul>

		</div>
		<div class="col-md-9">
			
			
			<jsp:include page="company_InfoCards.jsp"></jsp:include>

			<div class="row" style="margin-top: 50px;">

				<div id="verifyworker" class="col-md-8">
					<div class="panelfooter">
						<div class="panel-heading">Requests For be a Worker</div>
						<div class="panel-body">
							<table class="table">
								<tr>
									<th>Worker ID</th>
									<th>Name</th>
									<th>CNIC</th>
									<th>Action</th>
								</tr>
								<c:forEach items="${workersRequests}" var="r">
								<tr>
									<td><c:out value="${r.id}"></c:out></td>
									<td><c:out value="${r.worker}"></c:out></td>
									<td><c:out value="${r.cNIC}"></c:out></td>
									<td><button onclick="verifyworker(<c:out value="${r.id}"></c:out>,<%out.print(c.getId()); %>)" class="btn btn-success">Approve This Worker</button></td>
								</tr>
								</c:forEach>

							</table>


						</div>


					</div>

				</div>
				
				<div  class="col-md-4">
					<div class="panelfooter">
						<div class="panel-heading"><h5><%out.print(city.getCity()); %></h5></div>
						<div id="map" class="panel-body" style="height:200px;">
						
						</div>
					</div>
					
					
				</div>

			</div>




			<div class="panelfooter" style="margin-top: 50px;">
				<div class="panel-heading">Company Worker</div>
				<div class="panel-body">
					<table class="table ">
						<tr>
							<th>ID</th>
							<th>WORKER</th>
							<th>CNIC</th>
							<th>MOBILE</th>
							<th>EMAIL</th>
							<th>D.O.B</th>
						</tr>
						<c:forEach items="${companyWorkers}" var="r">
						<tr>
							<td><c:out value="${r.id}"></c:out></td>
							<td><c:out value="${r.worker}"></c:out></td>
							<td><c:out value="${r.cNIC}"></c:out></td>
							<td><c:out value="${r.mobile}"></c:out></td>
							<td><c:out value="${r.email}"></c:out></td>
							<td><c:out value="${r.dOB}"></c:out></td>
						</tr>
						</c:forEach>
					</table>
					


				</div>
			</div>





		</div>
	</div>
	
	
	<!-- map Code -->
	<script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: <%out.print(city.getLatitude());%>, lng: <%out.print(city.getLongitude());%>},
          zoom: 8
        });
      }
      
      //Verify A Worker
      function verifyworker(workerID,companyID){
    		console.log("WorkerID "+workerID);
    		console.log("CompanyID "+companyID);
    		
    		$.ajax({url: "VerifyWorkerByCompany?wID="+workerID+"&companyID="+companyID,success: function(r){
    			console.log(r);
    			$("#verifyworker").html(r);
    		}});
      }
    </script> 
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBud-B2VEB2MFSVUig2ykXvz7nISkc27PM&callback=initMap"
    async defer></script>
    <!-- map Code-->
    
</body>
</html>