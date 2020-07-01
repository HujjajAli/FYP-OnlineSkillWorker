<%@page import="com.workerservices.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
    Customer customer = null;
	if(session.getAttribute("login_customer")==null){
	  
	}else{
		customer = (Customer)session.getAttribute("login_customer");
	}
%>
</head>
<body>
    <%if(customer == null){ %>
	<!-- NavBar starts-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-mynav fixed-top">
      <a class="navbar-brand" href="index.jsp">* OSW *</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-item nav-link" href="index.jsp">Home</a>
          <a class="nav-item nav-link" href="#">Workers</a>
          <a class="nav-item nav-link" href="user_PricingModel.jsp">Pricing</a>
          <a class="nav-item nav-link" href="worker_LiveTrack.jsp">Live track<span class="sr-only">(current)</span></a>
          <a class="nav-item nav-link" href="user_AboutUs.jsp">About-us</a>
          <a class="nav-item nav-link" href="user_HelpLine.jsp">Helpline</a>
          <a class="nav-item nav-link login" href="login.jsp">Login Here</a>
        </div>
      </div>
    </nav>
  <!-- NavBar Ends-->
  <%}else{ %>
  	<!-- NavBar starts-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-mynav fixed-top">
      <a class="navbar-brand" href="index.jsp">* OSW *</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-item nav-link " href="index.jsp">Home </a>
          <a class="nav-item nav-link" href="#">Workers</a>
          <a class="nav-item nav-link" href="user_PricingModel.jsp">Pricing</a>
          <a class="nav-item nav-link " href="worker_LiveTrack.jsp">Live Track<span class="sr-only">(current)</span></a>
          <a class="nav-item nav-link" href="user_AboutUs.jsp">About-us</a>
          <a class="nav-item nav-link" href="user_HelpLine.jsp">Helpline</a>
          <a class="nav-item nav-link" href="LogoutController">Logout</a>
          <a class="nav-item nav-link login" href="user_Profile.jsp"><%out.print(customer.getCustomer()); %></a>
        </div>
      </div>
    </nav>
  <!-- NavBar Ends-->
  <%} %>
</body>
</html>