package com.workerservices.model;

public class Worker {
	
	private int id;         
	private String worker;         
	private String cNIC ;         
	private String dOB;         
	private String mobile; 
	private String email;         
	private String password;         
	private Trade trade;          
	private WorkerAddress address;
	private String isVerified;
	private double rating;
	
	
	
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcNIC() {
		return cNIC;
	}
	public void setcNIC(String cNIC) {
		this.cNIC = cNIC;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public WorkerAddress getAddress() {
		return address;
	}
	public void setAddress(WorkerAddress address) {
		this.address = address;
	}
	public String getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Worker [id=" + id + ", worker=" + worker + ", cNIC=" + cNIC + ", dOB=" + dOB + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", trade=" + trade + ", address=" + address
				+ ", isVerified=" + isVerified + "]";
	}
	
	
}
