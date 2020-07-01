<%@page import="com.workerservices.daoImplement.Worker_DAO_Implement"%>
<%@page import="com.workerservices.dao.Worker_DAO"%>
<%@page import="com.workerservices.model.Worker"%>
<%@page import="java.util.List"%>
<%@page import="com.workerservices.daoImplement.Company_DAO_Implement"%>
<%@page import="com.workerservices.dao.Company_DAO"%>
<%@page import="com.workerservices.model.CityData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Worker_DAO wdao = new Worker_DAO_Implement();
	Company_DAO cdao = new Company_DAO_Implement();
	CityData city = cdao.getCityById(1);
	
	List<Worker> workerData = wdao.getVarifiedWorkers();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/livetrack.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	margin-top: 56px;
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<title>Track Workers</title>
</head>
<body>
	<jsp:include page="user_Navbar.jsp"></jsp:include>

	<div id="map"></div>
	
	<!--
secure
AIzaSyBmOFTYtcpxQfc1mi7mbQm2ntpF94Ah1F0
unsecure
AIzaSyBxCLLTR3fn3bP9F8d2EaMPhi2WkQKOMpE
-->

	<jsp:include page="user_Footer.jsp"></jsp:include>
	
	<!-- map Code -->
	<script>
	<%for(Worker w:workerData){%>
	console.log("<%out.print(w.getWorker());%>");
	console.log("<%out.print(w.getAddress().getLatitude());%>");
	console.log("<%out.print(w.getAddress().getLongitude());%>");
<%}%>
	
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: <%out.print(city.getLatitude());%>, lng: <%out.print(city.getLongitude());%>},
          zoom: 8
        });
        <%for(Worker w:workerData){%>
        marker  = new google.maps.Marker({
			position : {lat: <%out.print(w.getAddress().getLatitude());%>, lng: <%out.print(w.getAddress().getLongitude());%>},
			title    : "<%out.print(w.getWorker());%>"
		});
        marker.setMap(map);
        <%}%>
      }
      
    </script> 
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBud-B2VEB2MFSVUig2ykXvz7nISkc27PM&callback=initMap"
    async defer></script>
    <!-- map Code-->

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