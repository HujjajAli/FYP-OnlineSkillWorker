<%@page import="com.workerservices.daoImplement.Company_DAO_Implement"%>
<%@page import="com.workerservices.dao.Company_DAO"%>
<%@page import="com.workerservices.model.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Company c        = (Company)request.getSession().getAttribute("company"); 
Company_DAO cdao = new Company_DAO_Implement();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
				<div class="col-md-3 ">
					<div class="panel1">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal"
										style="font-size: 4.5em;"></span>
								</div>
								<div class="col-md-9 text-right">
									<div style="font-size: 2.5em;"><%out.print(cdao.numberofCompanyWorkers(c.getTrade().getId())); %></div>
									<div style="font-size: 1.5em;">Workers</div>
								</div>
							</div>
						</div>
						<a href="company_Workers.jsp">
							<div class="panel-footer panelfooter">
								<div class="pull-left">View</div>
								<div class="pull-right">
									<span class="glyphicon glyphicon-circle-arrow-right"></span>
								</div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>



				<div class="col-md-3">
					<div class="panel2">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-th-list"
										style="font-size: 4.5em;"></span>
								</div>
								<div class="col-md-9 text-right">
									<div style="font-size: 2.5em;"><%out.print(cdao.numberOfRequestforTrade(c.getTrade().getId())); %></div>
									<div style="font-size: 1.5em;">Requests</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer panelfooter">
								<div class="pull-left">View</div>
								<div class="pull-right">
									<span class="glyphicon glyphicon-circle-arrow-right"></span>
								</div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>



				<div class="col-md-3">
					<div class="panel3">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal"
										style="font-size: 4.5em;"></span>
								</div>
								<div class="col-md-9 text-right">
									<div style="font-size: 2.5em;"><%out.print(cdao.numberOforders(c.getId())); %></div>
									<div style="font-size: 1.5em;">Orders</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer panelfooter">
								<div class="pull-left">View</div>
								<div class="pull-right">
									<span class="glyphicon glyphicon-circle-arrow-right"></span>
								</div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>



				<div class="col-md-3">
					<div class="panel4">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal"
										style="font-size: 4.5em;"></span>
								</div>
								<div class="col-md-9 text-right">
									<div style="font-size: 2.5em;"><%out.print(cdao.numberOfPandingOrders(c.getId())); %></div>
									<div style="font-size: 1.5em;">Pending Orders</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer panelfooter">
								<div class="pull-left">View</div>
								<div class="pull-right">
									<span class="glyphicon glyphicon-circle-arrow-right"></span>
								</div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>


			</div>
</body>
</html>