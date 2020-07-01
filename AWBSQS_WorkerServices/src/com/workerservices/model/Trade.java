package com.workerservices.model;

public class Trade {
	
	private int id;
	private String trade;
	private String discription;
	private int rate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", trade=" + trade + ", discription=" + discription + ", rate=" + rate + "]";
	}
	
	
	
	

}
