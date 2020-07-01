<%@page import="java.util.List"%>
<%@page import="com.workerservices.model.Trade"%>
<%@page import="com.workerservices.daoImplement.Worker_DAO_Implement"%>
<%@page import="com.workerservices.dao.Worker_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%Worker_DAO worker_dao = new Worker_DAO_Implement(); 
  List<Trade> trades    = worker_dao.getAllTrades();
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
<link rel="stylesheet" type="text/css" href="css/pricing.css">
<title>Pricing</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="user_Navbar.jsp"></jsp:include>
	
	<div class="container-fluid">
  <div class="panel2"style="margin-top: 100px;">
    <div class="row">
      <div class="col-md-12">
        <div class="container">
          <h1 class="stylishfonth text-center">Our pricing stragities</h1>
        <p class="stylishfontp text-center">OSW online skill worker business concept is to offer fashion and quality at the best price. Nationalwarehouse has since it was founded in 1947 grown into one of the world's leading fashion companies. The content of this site is copyright-protected and is the property of Nationalwarehouse. Nationalwarehouse is committed to accessibility. That commitment means Nationalwarehouse embraces WCAG guidelines and supports assistive technologies such as screen readers. If you are using a screen reader, magnifier, or other assistive technologies and are experiencing difficulties using this website, please call our TOLL-FREE support line (855-466-7467) for assistance.</p>
        </div>
      </div>
      <div class="col-md-12">
         <!--worker cards Starts-->
    <div class="container-fluid">
      <div class="jumbotron mt-5 parallax2 text-center">
          <h1>Worker Price</h1>
      </div>
      <div class="row">
      <%for(Trade t : trades){ %>
        <div class="col-sm-4">
          <!--Card Starts-->
            <div class="card-panel row">
            <div class="wrraper col-sm-12 text-center">
              <div class="card-title">
                <h1 class="title"><%out.print(t.getTrade()); %></h1>
              </div>
              <div class="card-price">
                <h1 class="price">PKR <%out.print(t.getRate()); %> ph</h1>
              </div>
              <div class="card-desc">
                <p class="desc"><%out.print(t.getDiscription()); %></p>
              </div>
            </div>
            </div>
          <!--Card Ends-->
        </div><%} %>

      </div>
    </div>
    <!--worker cards Ends-->
      </div>

    </div>
  </div>
</div>
	
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