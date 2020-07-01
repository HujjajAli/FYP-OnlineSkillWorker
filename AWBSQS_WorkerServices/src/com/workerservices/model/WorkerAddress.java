package com.workerservices.model;

public class WorkerAddress {
	
	private int id;          
	private String country;           
	private String city;                 
	private String locArea;          
	private String mapLocation;
	
	private String latitude;
	private String longitude;
	
	
	
	public void setLocation(String location){
		String data[] = location.split(",");
		setLatitude(data[0]);
		setLongitude(data[1]);
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getLocArea() {
		return locArea;
	}
	public void setLocArea(String locArea) {
		this.locArea = locArea;
	}
	public String getMapLocation() {
		return mapLocation;
	}
	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}
	@Override
	public String toString() {
		return "WorkerAddress [id=" + id + ", country=" + country + ", city=" + city + ", locArea=" + locArea
				+ ", mapLocation=" + mapLocation + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
	
	

}
