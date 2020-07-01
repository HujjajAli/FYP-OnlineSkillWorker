package com.workerservices.daoImplement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.workerservices.dao.Customer_DAO;
import com.workerservices.model.CityData;
import com.workerservices.model.CountryData;
import com.workerservices.model.Customer;
import com.workerservices.model.CustomerAddress;
import com.wrokerservices.db.DBHandler;

public class Customer_DAO_Implement implements Customer_DAO{
	DBHandler db = new DBHandler();
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Customer> data = new ArrayList<Customer>();
		String sql = "SELECT * FROM customer";
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Customer cos = new Customer();
				cos.setId(rs.getInt("id"));
				cos.setCustomer(rs.getString("Customer"));
				cos.setcNIC(rs.getString("CNIC"));
				cos.setDob(rs.getString("DOB"));
				cos.setPhone(rs.getString("Phone"));
				cos.setEmail(rs.getString("Email"));
				cos.setPassword(rs.getString("Password"));
				cos.setAddress(getAddressById(rs.getInt("Address")));
				
				data.add(cos);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return data;
	}

	@Override
	public CustomerAddress getAddressById(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		CustomerAddress ca = new CustomerAddress();
		ca.setId(id);
		String sql = "SELECT * FROM customeraddress where id = "+ca.getId();
		
		try{
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				ca.setCountry(rs.getString("Country"));
				ca.setCity(rs.getString("City"));
				ca.setLocArea(rs.getString("LocArea"));
				ca.setMapLocation(rs.getString("MapLocation"));
				ca.setLocation(rs.getString("MapLocation"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return ca;
	}
	
	public static void main(String[] args) {
		Customer_DAO cd = new Customer_DAO_Implement();
		List<Customer> list = cd.getAllCustomer();
		//System.out.println(cd.getAddressById(1).getLocArea());
		/*for (Customer customer : list) {
			System.out.println(customer.getCustomer());
			System.out.println(customer.getAddress().getLocArea());
		}*/
		int i = cd.saveAddress(list.get(0).getAddress());
		System.out.println("Address ID="+i);
	}

	@Override
	public Customer getCustoemerById(int id) {
		
		Connection con = db.getDBConnection();
		Customer cus = new Customer();
		String sql = "SELECT * FROM customer where id = "+id;
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				cus.setId(rs.getInt("id"));
				cus.setCustomer(rs.getString("Customer"));
				cus.setcNIC(rs.getString("CNIC"));
				cus.setDob(rs.getString("DOB"));
				cus.setEmail(rs.getString("Email"));
				cus.setPassword(rs.getString("Password"));
				cus.setGender(rs.getString("Gender"));
				cus.setPhone(rs.getString("Phone"));
				cus.setAddress(this.getAddressById(rs.getInt("Address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cus;
	}

	@Override
	public int saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		int row = 0;
		String fields = "INSERT INTO workerservicesdb.customer (Customer,CNIC,DOB,Phone,Email,Password,Gender,Address)";
		String values = "VALUES('"+c.getCustomer()+"','"+c.getcNIC()+"','"+c.getDob()+"','"+c.getPhone()+"',"
				+ "'"+c.getEmail()+"','"+c.getPassword()+"','"+c.getGender()+"',"+saveAddress(c.getAddress())+")";
		String sql = fields+values;
		try {
			Statement stm = con.createStatement();
			row  = stm.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int saveAddress(CustomerAddress add) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		int id = 0;
		String fields = "INSERT INTO customeraddress(Country, City, LocArea, MapLocation)";
		String values = "VALUES('"+add.getCountry()+"','"+add.getCity()+"','"+add.getLocArea()+"','"+add.getMapLocation()+"')";
		String sql    = fields+values;
		try {
			Statement stm = con.createStatement();
			int row = stm.executeUpdate(sql);
			if(row>0){
				ResultSet rs = stm.executeQuery("select * from customeraddress");
				while(rs.next()){
					id = rs.getInt("id");
				}
			}else{
				System.out.println("address Saving Error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Customer getCustoemerByEmail(String email) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		Customer cus = null;
		String sql = "SELECT * FROM customer where email = '"+email+"' ";
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				cus = new Customer();
				cus.setId(rs.getInt("id"));
				cus.setCustomer(rs.getString("Customer"));
				cus.setcNIC(rs.getString("CNIC"));
				cus.setDob(rs.getString("DOB"));
				cus.setEmail(rs.getString("Email"));
				cus.setPassword(rs.getString("Password"));
				cus.setGender(rs.getString("Gender"));
				cus.setAddress(this.getAddressById(rs.getInt("Address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cus;
	}

	

}
