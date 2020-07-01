package com.workerservices.daoImplement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.workerservices.dao.Worker_DAO;
import com.workerservices.model.Customer;
import com.workerservices.model.Trade;
import com.workerservices.model.Worker;
import com.workerservices.model.WorkerAddress;
import com.wrokerservices.db.DBHandler;

public class Worker_DAO_Implement implements Worker_DAO {
	DBHandler db = new DBHandler();
	
	@Override
	public List<Trade> getAllTrades() {
		Connection con = db.getDBConnection();
		
		List<Trade> data = new ArrayList<Trade>();
		String sql = "SELECT * FROM trades";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Trade t = new Trade();
				t.setId(rs.getInt("id"));
				t.setTrade(rs.getString("trade"));
				t.setDiscription(rs.getString("discription"));
				t.setRate(rs.getInt("price"));
				
				data.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Worker> getAllWorkers() {
		Connection con = db.getDBConnection();
		List<Worker> data = new ArrayList<Worker>();
		String sql = "SELECT * FROM worker";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				Worker sw = new Worker();
				sw.setId(rs.getInt("id"));
				sw.setWorker(rs.getString("Worker"));
				sw.setcNIC(rs.getString("CNIC"));
				sw.setdOB(rs.getString("DOB"));
				sw.setMobile(rs.getString("Mobile"));
				sw.setEmail(rs.getString("Email"));
				sw.setPassword(rs.getString("Password"));
				sw.setTrade(getTradeByID(rs.getInt("Trade")));
				sw.setAddress(getAddressByID(rs.getInt("Address")));
				
				data.add(sw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return data;
	}
	
	@Override
	public Trade getTradeByID(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		Trade trade = new Trade();
		trade.setId(id);
		String sql = "SELECT * FROM trades where id = "+trade.getId();
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				trade.setTrade(rs.getString("trade"));
				trade.setDiscription(rs.getString("discription"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trade;
	}

	@Override
	public WorkerAddress getAddressByID(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		WorkerAddress ads = new WorkerAddress();
		ads.setId(id);
		String sql = "SELECT * FROM workeraddress where id = "+ads.getId();
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				ads.setCountry(rs.getString("Country"));
				ads.setCity(rs.getString("City"));
				ads.setLocArea(rs.getString("LocArea"));
				ads.setMapLocation(rs.getString("MapLocation"));
				ads.setLocation(rs.getString("MapLocation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ads;
	}
	
	@Override
	public int registratorWorker(Worker w) {
		// TODO Auto-generated method stub
		int status = 0;
		Connection con = db.getDBConnection();
		String fields = "INSERT INTO worker(Worker, CNIC, DOB, Mobile, Email,"
				        + "Password, Trade, Address,isVerified)";
		String values = "VALUES('"+w.getWorker()+"','"+w.getcNIC()+"','"+w.getdOB()+"'"
				       + ",'"+w.getMobile()+"','"+w.getEmail()+"','"+w.getPassword()+"',"
				       + ""+w.getTrade().getId()+","+saveAddress(w.getAddress())+",'No')";
		
		String sql = fields+values;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int row = stm.executeUpdate(sql);
			if(row>0){
				status = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public Worker getWorkerById(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		Worker data = new Worker();
		String sql = "SELECT * FROM worker WHERE id="+id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				data.setId(rs.getInt("id"));
				data.setWorker(rs.getString("Worker"));
				data.setcNIC(rs.getString("CNIC"));
				data.setdOB(rs.getString("DOB"));
				data.setMobile(rs.getString("Mobile"));
				data.setEmail(rs.getString("Email"));
				data.setPassword(rs.getString("Password"));
				data.setTrade(getTradeByID(rs.getInt("Trade")));
				data.setAddress(getAddressByID(rs.getInt("Address")));
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
	
	

	@Override
	public Worker getWorkerByEmail(String email) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		Worker data = new Worker();
		String sql = "SELECT * FROM worker WHERE Email='"+email+"' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				data.setId(rs.getInt("id"));
				data.setWorker(rs.getString("Worker"));
				data.setcNIC(rs.getString("CNIC"));
				data.setdOB(rs.getString("DOB"));
				data.setMobile(rs.getString("Mobile"));
				data.setEmail(rs.getString("Email"));
				data.setPassword(rs.getString("Password"));
				data.setTrade(getTradeByID(rs.getInt("Trade")));
				data.setAddress(getAddressByID(rs.getInt("Address")));
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int saveAddress(WorkerAddress add) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		int id = 0;
		String fields = "INSERT INTO workeraddress(Country, City, LocArea, MapLocation)";
		String values = "VALUES('"+add.getCountry()+"','"+add.getCity()+"','"+add.getLocArea()+"','"+add.getMapLocation()+"')";;
		String sql    = fields+values;
		try {
			Statement stm = con.createStatement();
			//int row = stm.executeUpdate(sql);
			int row = 1;
			if(row>0){
				ResultSet rs = stm.executeQuery("select * from workeraddress");
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
	public List<Worker> getVarifiedWorkers() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Worker> data = new ArrayList<Worker>();
		String sql = "SELECT * FROM worker WHERE isVerified='Yes' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				Worker sw = new Worker();
				sw.setId(rs.getInt("id"));
				sw.setWorker(rs.getString("Worker"));
				sw.setcNIC(rs.getString("CNIC"));
				sw.setdOB(rs.getString("DOB"));
				sw.setMobile(rs.getString("Mobile"));
				sw.setEmail(rs.getString("Email"));
				sw.setPassword(rs.getString("Password"));
				sw.setTrade(getTradeByID(rs.getInt("Trade")));
				sw.setAddress(getAddressByID(rs.getInt("Address")));
				sw.setRating(rs.getDouble("rating"));
				
				data.add(sw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return data;
	}

	@Override
	public boolean isBookedbyCustomer(int cID, int wID) {
		// TODO Auto-generated method stub
		boolean b = false;
		String sql = "SELECT * FROM workorders where CUSTOMER="+cID+" AND WORKER="+wID;
		Connection con = db.getDBConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			if(rs.next()){
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	public static void main(String[] args) {
		
		//DBHandler db = new DBHandler();
		Worker_DAO wd = new Worker_DAO_Implement();
		//List<Worker> list = wd.getAllWorkers();
		//WorkerAddress wa
		//Trade tr;
		/*for (Worker skil_Worker : list) {
			System.out.println(skil_Worker.getSkil_Worker());
			System.out.println(skil_Worker.getAddress().getCity());
			System.out.println(skil_Worker.getTrade().getTrade());
		}*/
		//wa = wd.getAddressByID(1);
		//tr = wd.getTradeByID(1);
		//System.out.println(tr.getTrade());
		System.out.println(wd.isBookedbyCustomer(2, 3));
	}

	@Override
	public List<Worker> getAllunbookedWorkers(int cID) {
		// TODO Auto-generated method stub
		Connection   con  = db.getDBConnection();
		List<Worker> data = new ArrayList<Worker>();
		String sql = "SELECT * FROM worker WHERE isVerified= 'Yes'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				Worker sw = new Worker();
				sw.setId(rs.getInt("id"));
				sw.setWorker(rs.getString("Worker"));
				sw.setcNIC(rs.getString("CNIC"));
				sw.setdOB(rs.getString("DOB"));
				sw.setMobile(rs.getString("Mobile"));
				sw.setEmail(rs.getString("Email"));
				sw.setPassword(rs.getString("Password"));
				sw.setTrade(getTradeByID(rs.getInt("Trade")));
				sw.setAddress(getAddressByID(rs.getInt("Address")));
				sw.setRating(rs.getDouble("rating"));
				
				if(this.isBookedbyCustomer(cID, sw.getId())){ }else{
					data.add(sw);
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return data;
	}

	

	

	

}
