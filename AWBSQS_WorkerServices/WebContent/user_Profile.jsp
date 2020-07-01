<%@page import="com.workerservices.model.WorkOrders"%>
<%@page import="java.util.List"%>
<%@page import="com.workerservices.daoImplement.WorkOrderDAO_Implement"%>
<%@page import="com.workerservices.dao.WorkOrderDAO"%>
<%@page import="com.workerservices.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/profile.css">
<link href='css/bootstrap.min.css' rel='stylesheet'>
<script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: linear-gradient( 109.6deg,  rgba(119,44,232,1) 11.5%, rgba(119,44,232,1) 91.2% );">
<%
Customer cus = null;
if(session.getAttribute("login_customer") == null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
}else{
	cus = (Customer)session.getAttribute("login_customer");
}

WorkOrderDAO orderDAO     =  new WorkOrderDAO_Implement();
List<WorkOrders> myOrders = orderDAO.getOrdersByCustomerID(cus.getId()); 
%>
	

	<div class="container panel text-center">
		<div style="color: white; margin-top: 50px; margin-bottom: 80px;">
			<img src="img/profile.png" alt="profile" height="200" width="200"
				style="border-radius: 50%; margin-bottom: 10px;">
			<h3><%out.print(cus.getCustomer()); %></h3>
		</div>
		<!--Table Stars-->

		<div class="panel-heading">Profile details</div>
		<div class="panelfooter">
			<div class="panel-heading">My Orders</div>
			<div class="panel-body">
				<table class="table">
					<tr>
					<th>Worker</th>
					<th>Order Time</th>
					<th>Order Date</th>
					<th>Order Status</th>
					<th>Action</th>
				</tr>
				<%for(WorkOrders word:myOrders){ %>
				<tr>
					<td><%out.print(word.getWorker().getWorker()); %></td>
					<td><%out.print(word.getTime()); %></td>
					<td><%out.print(word.getDate()); %></td>
					<td><%out.print(word.getOrderStatus()); %></td>
					<%if(word.getOrderStatus().equalsIgnoreCase("Pending")){%>
					<td><button class="btn btn-success" data-toggle='modal' data-target='#mod<%out.print(word.getId()); %>'>Cancel Order</button>
					<%}else{ %>
					<td><button class="btn btn-success" data-toggle='modal' data-target='#mod<%out.print(word.getId()); %>'>Rate  Worker</button></td>
					<%} %>
				</tr>
				<%} %>
					
			
				</table>
			</div>
		</div>

		<!--Table Ends-->
	</div>
	
	<div class="modal fade" id="mod" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content --> 
				<div class="modal-content">
				<div class="modal-header">
						<h5 class="modal-title">Worker :<br>Status :</h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<a href="login.jsp"  class="btn btn-success btn-lg">Login Here</a>
				</div>
				</div>
			</div>
	</div>
	
	<%for(WorkOrders word:myOrders){ %>
	<%if(word.getOrderStatus().equalsIgnoreCase("Pending")){%>
	<div class="modal fade" id="mod<%out.print(word.getId()); %>" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content --> 
				<div class="modal-content">
				<div class="modal-header">
						<h5 class="modal-title">Worker :<br>Status :<%out.print(word.getOrderStatus()); %></h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form action="CustomerOrderController" method="post">
					<input type="hidden" name="act" value="cancel">
					<div class="form-group">
				    	<label for="orderID" class="cols-sm-2 control-label">Order ID</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<input class="form-control" type="text" name="orderID" value="<%out.print(word.getId()); %>" readonly="readonly">
				    		</div>
				    	</div>
				    </div>
				    <div class="form-group">
				    	<label for="rate" class="cols-sm-2 control-label">Rating</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<input class="form-control" name="rate" type="number" min="1" max="10">
				    		</div>
				    	</div>
				    </div>
				    <div class="form-group">
				    	<label for="rate" class="cols-sm-2 control-label">Rating</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<textarea class="form-control" name="review" rows="5" cols="50"></textarea>
				    		</div>
				    	</div>
				    </div>
					
					
					<input type="submit" class="btn btn-success" value="Post Review & Cancel Order">
					</form>
				</div>
				</div>
			</div>
	</div>
	<%}else{ %>
		<div class="modal fade" id="mod<%out.print(word.getId()); %>" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content --> 
				<div class="modal-content">
				<div class="modal-header">
						<h5 class="modal-title">Worker :<br>Status :<%out.print(word.getOrderStatus()); %></h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form action="CustomerOrderController" method="post">
					<input type="hidden" name="act" value="complete">
					<div class="form-group">
				    	<label for="orderID" class="cols-sm-2 control-label">Order ID</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<input class="form-control" type="text" name="orderID" value="<%out.print(word.getId()); %>" readonly="readonly">
				    		</div>
				    	</div>
				    </div>
				    <div class="form-group">
				    	<label for="rate" class="cols-sm-2 control-label">Rating</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<input class="form-control" name="rate" type="number" min="1" max="10">
				    		</div>
				    	</div>
				    </div>
				    <div class="form-group">
				    	<label for="rate" class="cols-sm-2 control-label">Rating</label>
				    	<div class="cols-sm-10">
							<div class="input-group">
				    			<textarea class="form-control" name="review" rows="5" cols="50"></textarea>
				    		</div>
				    	</div>
				    </div>
					<input type="submit" class="btn btn-success" value="Post Order Review ">
					</form>
				</div>
				</div>
			</div>
	</div>
	<%} %>
	<%} %>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>