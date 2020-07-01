<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.workerservices.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h2>THis Page is for Show The test Results</h2></center>
	<h4>All Companies</h4>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Company</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Country</th>
				<th>City</th>
				<th>Address</th>
				<th>CUI No.</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${companies}" var="r">
				<tr>
					<td><c:out value="${r.id}"></c:out></td>
					<td><c:out value="${r.company}"></c:out></td>
					<td><c:out value="${r.phone}"></c:out></td>
					<td><c:out value="${r.email}"></c:out></td>
					<td><c:out value="${r.country}"></c:out></td>
					<td><c:out value="${r.city}"></c:out></td>
					<td><c:out value="${r.address}"></c:out></td>
					<td><c:out value="${r.cUINo}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<h4>All Customer</h4>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Customer</th>
				<th>CNIC</th>
				<th>DOB</th>
				<th>PHONE</th>
				<th>Email</th>
				<th>Password</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="r">
				<tr>
					<td><c:out value="${r.id}"></c:out></td>
					<td><c:out value="${r.customer}"></c:out></td>
					<td><c:out value="${r.cNIC}"></c:out></td>
					<td><c:out value="${r.dob}"></c:out></td>
					<td><c:out value="${r.phone}"></c:out></td>
					<td><c:out value="${r.email}"></c:out></td>
					<td><c:out value="${r.password}"></c:out></td>
					<td><c:out value="${r.address}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<h4>All Workers</h4>
	<table border="1">
		<thead>
			<tr>
				<th> ID       </th>
				<th> Worker   </th>
				<th> CNIC     </th>
				<th> DOB      </th>
				<th> PHONE    </th>
				<th> Email    </th>
				<th> Password </th>
				<th> Trade    </th>
				<th> Address  </th>
				<th> Company  </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${workers}" var="r">
				<tr>
				 	<td><c:out value="${r.id}"></c:out></td>
				 	<td><c:out value="${r.worker}"></c:out></td>
				 	<td><c:out value="${r.cNIC}"></c:out></td>
					<td><c:out value="${r.dOB}"></c:out></td>
					<td><c:out value="${r.mobile}"></c:out></td>
					<td><c:out value="${r.email}"></c:out></td>
					<td><c:out value="${r.password}"></c:out></td>
					<td><c:out value="${r.trade.trade}"></c:out></td>
					<td><c:out value="${r.address}"></c:out></td>
					<td><c:out value="Not Varified"></c:out></td>
				 </tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>