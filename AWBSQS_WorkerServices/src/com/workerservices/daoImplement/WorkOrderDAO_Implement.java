package com.workerservices.daoImplement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.workerservices.dao.Customer_DAO;
import com.workerservices.dao.WorkOrderDAO;
import com.workerservices.dao.Worker_DAO;
import com.workerservices.model.WorkOrders;
import com.wrokerservices.db.DBHandler;

public class WorkOrderDAO_Implement implements WorkOrderDAO {
	DBHandler db = new DBHandler();
	Customer_DAO cdao = new Customer_DAO_Implement();
	Worker_DAO   wdao = new Worker_DAO_Implement();
	@Override
	public List<WorkOrders> getOrdersByWorkerID(int wID) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<WorkOrders> data = new ArrayList<WorkOrders>();
		String sql = "select * from workorders where OrdStatus='Pending' AND WORKER ="+wID;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				
				WorkOrders ord = new WorkOrders();
				ord.setCostumer(cdao.getCustoemerById(rs.getInt("CUSTOMER")));
				ord.setWorker(wdao.getWorkerById(rs.getInt("WORKER")));
				ord.setId(rs.getInt("id"));
				ord.setTime(rs.getString("WOTime"));
				ord.setDate(rs.getString("WODate"));
				ord.setOrderStatus(rs.getString("OrdStatus"));
				ord.setPWODate(rs.getString("PWODate"));
				ord.setPWOFromTime(rs.getString("PWOFrom"));
				ord.setPWOToTime(rs.getString("PWOToTime"));
				data.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@Override
	public int hireWorker(WorkOrders ord) {
		// TODO Auto-generated method stub
		int row=0;
		Connection con = db.getDBConnection();
		String fields = "INSERT INTO workorders(CUSTOMER, WORKER, WOTime, WODate, OrdStatus,PWOFrom,PWOToTime,PWODate)";
		String values = "VALUES("+ord.getCostumer().getId()+","+ord.getWorker().getId()+",'"+ord.getTime()+"','"+ord.getDate()+"','"+ord.getOrderStatus()+"','"+ord.getPWOFromTime()+"','"+ord.getPWOToTime()+"','"+ord.getPWODate()+"')";
		String sql = fields+values;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int r = stm.executeUpdate(sql);
			if(r>0){
				row = 1;
			}else{
				System.out.println("Error in Query");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}
	
	

	@Override
	public int orderComplete(int oID,int wID) {
		// TODO Auto-generated method stub
		int row=0;
		Connection con = db.getDBConnection();
		//String sql = "UPDATE workorders SET OrdStatus = 'Complete',rating='0.0' WHERE CUSTOMER="+cID+" AND WORKER = "+wID+" ;";
		String sql = "UPDATE workorders SET OrdStatus = 'Complete',rating='0.0' WHERE id="+oID;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int r = stm.executeUpdate(sql);
			if(r>0){
				row = 1;
			}else{
				System.out.println("Error in Query");
			}
			updateWorkerRating(wID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public List<WorkOrders> getOrdersByCustomerID(int cID) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<WorkOrders> data = new ArrayList<WorkOrders>();
		String sql = "select * from workorders where CUSTOMER ="+cID;
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				
				WorkOrders ord = new WorkOrders();
				ord.setCostumer(cdao.getCustoemerById(rs.getInt("CUSTOMER")));
				ord.setWorker(wdao.getWorkerById(rs.getInt("WORKER")));
				ord.setId(rs.getInt("id"));
				ord.setTime(rs.getString("WOTime"));
				ord.setDate(rs.getString("WODate"));
				ord.setOrderStatus(rs.getString("OrdStatus"));
				ord.setPWODate(rs.getString("PWODate"));
				ord.setPWOFromTime(rs.getString("PWOFrom"));
				ord.setPWOToTime(rs.getString("PWOToTime"));
				
				if(ord.getOrderStatus().equalsIgnoreCase("Cancel")){
					
				}else{
					data.add(ord);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int customerOrderRating(int oID, double rate, String review) {
		// TODO Auto-generated method stub
		int row=0;
		Connection con = db.getDBConnection();
		String sql = "UPDATE workorders SET rating='"+rate+"', review='"+review+"' WHERE id="+oID;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int r = stm.executeUpdate(sql);
			if(r>0){
				row = 1;
			}else{
				System.out.println("Error in Query");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
		
	}

	@Override
	public int customerOrderCancel(int oID, double rate, String review) {
		// TODO Auto-generated method stub
		int row=0;
		Connection con = db.getDBConnection();
		String sql = "UPDATE workorders SET OrdStatus='Cancel', rating='"+rate+"', review='"+review+"' WHERE id="+oID;
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int r = stm.executeUpdate(sql);
			if(r>0){
				row = 1;
			}else{
				System.out.println("Error in Query");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public void updateWorkerRating(int wID) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		String sql = "select * from workorders where WORKER = "+wID;
		double ratingSum = 0.0;
		int count =0;
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql); 
			while(rs.next()){
				WorkOrders ord = new WorkOrders();
				String strRate = rs.getString("rating");
				if(strRate == null){/*System.out.println(strRate);*/}
				else{
					System.out.println(strRate);
					ratingSum = ratingSum + Double.parseDouble(strRate);
					count++;
				}
			}
			double rating = ratingSum/count;
			sql = "update worker set rating='"+rating+"' where id="+wID;
			stm.executeUpdate(sql);
			System.out.println("Rating :"+rating);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void  main(String[] args) {
		WorkOrderDAO d = new WorkOrderDAO_Implement();
		//List<WorkOrders> list = d.getOrdersByWorkerID(1);
		List<WorkOrders> list = d.getGetReviewsByWorkerId(1);
		for (WorkOrders workOrders : list) {
			System.out.println(workOrders);
		}
		//d.orderComplete(2, 1);
		//d.updateWorkerRating(1);
	}

	@Override
	public List<WorkOrders> getGetReviewsByWorkerId(int wid) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<WorkOrders> data = new ArrayList<WorkOrders>();
		String sql = "select * from workorders where WORKER="+wid+" AND OrdStatus = 'Complete' AND review IS NOT NULL";
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()){
				
				WorkOrders ord = new WorkOrders();
				ord.setCostumer(cdao.getCustoemerById(rs.getInt("CUSTOMER")));
				ord.setWorker(wdao.getWorkerById(rs.getInt("WORKER")));
				ord.setId(rs.getInt("id"));
				ord.setTime(rs.getString("WOTime"));
				ord.setDate(rs.getString("WODate"));
				ord.setOrderStatus(rs.getString("OrdStatus"));
				ord.setPWODate(rs.getString("PWODate"));
				ord.setPWOFromTime(rs.getString("PWOFrom"));
				ord.setPWOToTime(rs.getString("PWOToTime"));
				ord.setReview(rs.getString("review"));
				data.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
