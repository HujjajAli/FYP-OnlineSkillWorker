<%@page import="com.workerservices.model.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Company c        = (Company)request.getSession().getAttribute("company"); %>
	<nav class="navbar bg-mynav">
	<div class="container">
		<div class="navbar-header">
			<a href="company_Dashboard.jsp" class="navbar-brand">*OSW*</a>
		</div>
		<ul class="nav navbar-nav navbar-right">

			<li><a href="company_Dashboard.jsp">Home</a></li>
			<li class="dropdown"><a href="#" data-toggle="dropdown"
				class="dropdown-toggle"><%out.print(c.getCompany()); %> <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">Profile</a></li>
					<li><a href="LogoutController">Logout</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
</body>
</html>