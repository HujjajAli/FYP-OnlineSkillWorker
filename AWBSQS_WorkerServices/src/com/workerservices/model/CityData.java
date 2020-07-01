package com.workerservices.model;

public class CityData {
	
	private int id;
	private String city;
	private String latitude;
	private String longitude;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public void setLocation(String location){
		String data[] = location.split(",");
		setLatitude(data[0]);
		setLongitude(data[1]);
	}
	
	/*public static void main(String[] args) {
		CityData cd = new CityData();
		
		String name = "Lahore";
		String loc  = "56.8607,99.0011";
		
		cd.setCity(name);
		cd.setLocation(loc);
		
		System.out.println(cd.getCity());
		System.out.println(cd.getLatitude());
		System.out.println(cd.getLongitude());
	}*/
}
