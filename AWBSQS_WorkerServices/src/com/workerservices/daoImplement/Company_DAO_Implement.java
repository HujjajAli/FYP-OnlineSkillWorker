package com.workerservices.daoImplement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.workerservices.dao.Company_DAO;
import com.workerservices.model.CityData;
import com.workerservices.model.Company;
import com.workerservices.model.CountryData;
import com.workerservices.model.Trade;
import com.workerservices.model.Worker;
import com.wrokerservices.db.DBHandler;

public class Company_DAO_Implement implements Company_DAO {
	DBHandler db = new DBHandler();

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Company> data = new ArrayList<Company>();
		String sql = "SELECT * FROM company";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Company c = new Company();
				c.setId(rs.getInt("id"));
				c.setCompany(rs.getString("Company"));
				c.setPhone(rs.getString("Phone"));
				c.setEmail(rs.getString("Email"));
				c.setCountry(rs.getString("Country"));
				c.setCity(rs.getString("City"));
				c.setAddress(rs.getString("Address"));
				c.setcUINo(rs.getString("CUINo"));
				c.setPassword(rs.getString("Password"));

				data.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Worker> getWorkerRequests(int trade) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Worker> data = new ArrayList<Worker>();
		String sql = "SELECT * FROM worker where isVerified='No' AND Trade="+trade;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Worker sw = new Worker();
				sw.setId(rs.getInt("id"));
				sw.setWorker(rs.getString("Worker"));
				sw.setcNIC(rs.getString("CNIC"));
				sw.setdOB(rs.getString("DOB"));
				sw.setMobile(rs.getString("Mobile"));
				sw.setEmail(rs.getString("Email"));
				sw.setPassword(rs.getString("Password"));
				// sw.setTrade(getTradeByID(rs.getInt("Trade")));
				// sw.setAddress(getAddressByID(rs.getInt("Address")));

				data.add(sw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<CountryData> getCountryData() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<CountryData> data = new ArrayList<CountryData>();
		String sql = "SELECT * FROM countrydata ;";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				CountryData cd = new CountryData();
				cd.setId(rs.getInt("id"));
				cd.setCountry(rs.getString("country"));
				data.add(cd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<CityData> getCityData() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<CityData> data = new ArrayList<CityData>();
		String sql = "SELECT * FROM citydata";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CityData> getCityDataByCountryId(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<CityData> data = new ArrayList<CityData>();
		String sql = "SELECT * FROM citydata where country ="+id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				CityData cd = new CityData();
				cd.setId(rs.getInt("id"));
				cd.setCity(rs.getString("city"));
				cd.setLocation(rs.getString("MapLocation"));
				data.add(cd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
	
	@Override
	public int saveCompany(Company c) {
		// TODO Auto-generated method stub
		System.out.println(c);
		int status = 0;
		Connection con = db.getDBConnection();
		String fields = "INSERT INTO company(Company, Phone, Password,Email, "
				        + "Country, City, Address, CUINo,Owner,CNIC,Trade)";
		String values = "VALUES('"+c.getCompany()+"','"+c.getPhone()+"','"+c.getPassword()+"','"+c.getEmail()+""
				+ "','"+c.getCountry()+"','"+c.getCity()+"','"+c.getAddress()+"','"+c.getcUINo()+"'"
				+ ",'"+c.getOwner()+"','"+c.getCnic()+"','"+c.getTrade().getId()+"')";
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
	public CityData getCityById(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		CityData data = new CityData();
		String sql = "select * from citydata where id="+id;
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				data.setId(rs.getInt("id"));
				data.setCity(rs.getString("city"));
				data.setLocation(rs.getString("MapLocation"));
				System.out.println("City : "+data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public CountryData getCountryById(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		CountryData data = new CountryData();
		String sql = "select * from countrydata where id="+id;
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				data.setId(rs.getInt("id"));
				data.setCountry(rs.getString("country"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@Override
	public Company getCompanyByEmail(String email) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		Company data =null;
		String sql = "select * from company where Email='"+email+"';";
		Statement stm;
		System.out.println(sql);
		try {
			    
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery(sql);
				if (rs.next()) {
					data = new Company();
					data.setId(rs.getInt("id"));
					data.setCompany(rs.getString("Company"));
					data.setPhone(rs.getString("Phone"));
					data.setEmail(rs.getString("Email"));
					data.setCountry(rs.getString("Country"));
					data.setCity(rs.getString("City"));
					data.setAddress(rs.getString("Address"));
					data.setcUINo(rs.getString("CUINo"));
					data.setPassword(rs.getString("Password"));
					data.setTrade(getCompanyTradeById(rs.getInt("Trade")));
				}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return data;
		
	}
	
	@Override
	public List<Worker> getCompanyWorkers() {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Worker> data = new ArrayList<Worker>();
		String sql = "SELECT * FROM worker where";
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
		//		sw.setTrade(getTradeByID(rs.getInt("Trade")));
		//		sw.setAddress(getAddressByID(rs.getInt("Address")));
				
				data.add(sw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Integer> getVarifiedWorkers(int id) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		List<Integer> data = new ArrayList<Integer>();
		String sql = "SELECT * FROM varifiedworkers WHERE Company="+id;
		try {
		    Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				data.add(rs.getInt("Worker"));
			}
		}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
		}
		return data;
	}

	@Override
	public int verifyWorker(int workerID, int companyID){
		// TODO Auto-generated method stub
		int row = 0;
		Connection con = db.getDBConnection();
		String sql = "INSERT INTO varifiedworkers(Worker, Company, CertificationNumber)VALUES("
				+ " "+workerID+","+companyID+",1234)";
		System.out.println(sql);
		try {
			Statement stm = con.createStatement();
			int r = stm.executeUpdate(sql);
			if(r>0){
				sql = "UPDATE worker SET isVerified = 'Yes' WHERE id ="+workerID;
				r   = stm.executeUpdate(sql);
				if(r>0){
					row = 1;
				}
				
			}else{
				System.out.println("Error Verify Worker");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public Trade getCompanyTradeById(int id) {
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
	public int numberofCompanyWorkers(int tid) {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT * FROM worker WHERE isVerified = 'Yes' AND Trade ="+tid;
		Connection con = db.getDBConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int numberOfRequestforTrade(int tid) {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT * FROM worker WHERE isVerified = 'No' AND Trade ="+tid;
		Connection con = db.getDBConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {

		Company_DAO cd = new Company_DAO_Implement();
		List<Company> list = cd.getAllCompanies();
		/*for (Company company : list) {
			System.out.println(company.getCompany());
			System.out.println(company.getcUINo());
		}*/
		System.out.println("Workers  :"+cd.numberofCompanyWorkers(1));
		System.out.println("Requests :"+cd.numberOfRequestforTrade(1));
		System.out.println("Orders :"+cd.numberOforders(1));
	}

	@Override
	public int numberOforders(int cid) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		int count = 0;
		List<Integer> workers = this.getVarifiedWorkers(cid);
		for(Integer i:workers){
			String sql = "SELECT * FROM workorders WHERE WORKER ="+i;
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} 
		
		return count;
	}

	@Override
	public int numberOfPandingOrders(int cid) {
		// TODO Auto-generated method stub
		Connection con = db.getDBConnection();
		int count = 0;
		List<Integer> workers = this.getVarifiedWorkers(cid);
		for(Integer i:workers){
			String sql = "SELECT * FROM workorders WHERE OrdStatus='Panding' AND WORKER ="+i;
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} 
		
		return count;
	}

}
