<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<script>
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 2,
				center : {
					lat : -33.865427,
					lng : 151.196123
				},
				mapTypeId : 'terrain'
			});

			// Create a <script> tag and set the USGS URL as the source.
			var script = document.createElement('script');

			// This example uses a local copy of the GeoJSON stored at
			// http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp
			script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';
			document.getElementsByTagName('head')[0].appendChild(script);

		}

		function eqfeed_callback(results) {
			var heatmapData = [];
			for (var i = 0; i < results.features.length; i++) {
				var coords = results.features[i].geometry.coordinates;
				var latLng = new google.maps.LatLng(coords[1], coords[0]);
				heatmapData.push(latLng);
			}
			var heatmap = new google.maps.visualization.HeatmapLayer({
				data : heatmapData,
				dissipating : false,
				map : map
			});
		}
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxCLLTR3fn3bP9F8d2EaMPhi2WkQKOMpE&libraries=visualization&callback=initMap">
		
	</script>





	<!--
secure
AIzaSyBmOFTYtcpxQfc1mi7mbQm2ntpF94Ah1F0
unsecure
AIzaSyBxCLLTR3fn3bP9F8d2EaMPhi2WkQKOMpE
-->

	<jsp:include page="user_Footer.jsp"></jsp:include>

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