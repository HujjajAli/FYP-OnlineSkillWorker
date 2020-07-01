package com.workerservices.model;

public class WorkOrders {
	
	private int id;
	private Customer costumer;
	private Worker   worker;
	private String   time;
	private String   date;
	private String   orderStatus;
	private String   PWOFromTime;
	private String   PWOToTime;
	private String   PWODate;
	private String   review;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCostumer() {
		return costumer;
	}
	public void setCostumer(Customer costumer) {
		this.costumer = costumer;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public String getPWOFromTime() {
		return PWOFromTime;
	}
	public void setPWOFromTime(String pWOFromTime) {
		PWOFromTime = pWOFromTime;
	}
	public String getPWOToTime() {
		return PWOToTime;
	}
	public void setPWOToTime(String pWOToTime) {
		PWOToTime = pWOToTime;
	}
	public String getPWODate() {
		return PWODate;
	}
	public void setPWODate(String pWODate) {
		PWODate = pWODate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "WorkOrders [id=" + id + ", costumer=" + costumer + ", worker=" + worker + ", time=" + time + ", date="
				+ date + ", orderStatus=" + orderStatus + ", PWOFromTime=" + PWOFromTime + ", PWOToTime=" + PWOToTime
				+ ", PWODate=" + PWODate + ", review=" + review + "]";
	}
	
	

}
