package com.workerservices.model;

public class Customer {
	
	private int id;
	private String customer;
	private String cNIC;
	private String dob;
	private String phone;
	private String email;
	private String password;
	private String gender;
	private CustomerAddress address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getcNIC() {
		return cNIC;
	}
	public void setcNIC(String cNIC) {
		this.cNIC = cNIC;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CustomerAddress getAddress() {
		return address;
	}
	public void setAddress(CustomerAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer=" + customer + ", cNIC=" + cNIC + ", dob=" + dob + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	/*
	 
	 <h4>All Workers</h4>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Worker</th>
				<th>CNIC</th>
				<th>DOB</th>
				<th>PHONE</th>
				<th>Email</th>
				<th>Password</th>
				<th>Trade</th>
				<th>Address</th>
				<th>Company</th>
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
	 
	  */
	 
	

}
