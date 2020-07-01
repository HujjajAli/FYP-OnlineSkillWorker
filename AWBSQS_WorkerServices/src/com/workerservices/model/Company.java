package com.workerservices.model;

public class Company {
	
	private int id;
	private String company;
	private String phone;
	private String email;
	private String password;
	private String country;
	private String city;
	private String address;
	private String cUINo;
	private String owner;
	private String cnic;
	private Trade trade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getcUINo() {
		return cUINo;
	}
	public void setcUINo(String cUINo) {
		this.cUINo = cUINo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", company=" + company + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", country=" + country + ", city=" + city + ", address=" + address + ", cUINo=" + cUINo
				+ ", owner=" + owner + ", cnic=" + cnic + ", trade=" + trade.getTrade() + "]";
	}
	
	
	
}
