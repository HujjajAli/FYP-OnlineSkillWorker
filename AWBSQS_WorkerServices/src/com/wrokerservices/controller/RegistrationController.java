package com.wrokerservices.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workerservices.dao.Company_DAO;
import com.workerservices.dao.Customer_DAO;
import com.workerservices.dao.Worker_DAO;
import com.workerservices.daoImplement.Company_DAO_Implement;
import com.workerservices.daoImplement.Customer_DAO_Implement;
import com.workerservices.daoImplement.Worker_DAO_Implement;
import com.workerservices.model.CityData;
import com.workerservices.model.Company;
import com.workerservices.model.CountryData;
import com.workerservices.model.Customer;
import com.workerservices.model.CustomerAddress;
import com.workerservices.model.Trade;
import com.workerservices.model.Worker;
import com.workerservices.model.WorkerAddress;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Worker_DAO wd     = new Worker_DAO_Implement();
	Company_DAO cd    = new Company_DAO_Implement();
	Customer_DAO cdao = new Customer_DAO_Implement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if(act.equalsIgnoreCase("CompanyRegistration")){//Company Registration Logic
			System.out.println("Company Registration ");
			
			String company  = request.getParameter("name");
			String phone    = request.getParameter("phone");
			String email    = request.getParameter("email");
			String password = request.getParameter("password");
			String city     = request.getParameter("city");
			String country  = request.getParameter("country");
			String address  = request.getParameter("address");
			String cUI      = request.getParameter("cui");
			String owner    = request.getParameter("owner");
			String cnic     = request.getParameter("cnic");
			String trade    = request.getParameter("trade"); 
			Trade t = wd.getTradeByID(Integer.parseInt(trade));
			
			Company cmp = new Company();
			cmp.setCompany(company);
			cmp.setEmail(email);
			cmp.setPhone(phone);
			cmp.setPassword(password);
			cmp.setAddress(address);
			cmp.setCity(city);
			cmp.setCountry(country);
			cmp.setcUINo(cUI);
			cmp.setOwner(owner);
			cmp.setCnic(cnic);
			cmp.setTrade(t);
			
			cd.saveCompany(cmp);
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if(act.equalsIgnoreCase("workerRegistration")){//Worker Registration Logic
			String worker = request.getParameter("worker");
			String email  = request.getParameter("email");
			String password  = request.getParameter("password");
			String phone  = request.getParameter("phone");
			String cnic   = request.getParameter("cnic");
			String dob    = request.getParameter("dob");
			String trade  = request.getParameter("trade");
			String gender = request.getParameter("gender");
			
			String area     = request.getParameter("area");
			String country  = request.getParameter("country");
			String city     = request.getParameter("city");
			
			HttpSession ses       = request.getSession();
			WorkerAddress address = (WorkerAddress)ses.getAttribute("sesWorkerAddress");
			
			CountryData countryData = cd.getCountryById(Integer.parseInt(country));
			CityData    cityData    = cd.getCityById(Integer.parseInt(city));
			
			System.out.println("City Name :"+cityData.getCity());		
			address.setCity(cityData.getCity());
			address.setCountry(countryData.getCountry());
			address.setLocArea(area);
			
			
			int tradeInt  = Integer.parseInt(trade);
			Trade selectedTrade = wd.getTradeByID(tradeInt);
			Worker w = new Worker();
			
			w.setWorker(worker);
			w.setEmail(email); 
			w.setMobile(phone);
			w.setcNIC(cnic);
			w.setdOB(dob);
			w.setTrade(selectedTrade);
			w.setPassword(password);
			w.setAddress(address);
			
			System.out.println("Gender :"+gender);
			
			System.out.println(w);
			System.out.println(address);
			int row = wd.registratorWorker(w);
			if(row>0){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("worker_Registration.jsp").forward(request, response);
			}
		}else if(act.equalsIgnoreCase("userRegistration")){
			Customer cus = new Customer();
			String customer = request.getParameter("name");
			String email    = request.getParameter("email");
			String password = request.getParameter("password");
			String phone    = request.getParameter("phone"); 
			String cnic     = request.getParameter("cnic");
			String dob      = request.getParameter("dob");
			String gender   = request.getParameter("gender");
			String area   = request.getParameter("area");
			String country  = request.getParameter("country");
			String city     = request.getParameter("city");
			System.out.println("city id "+city);
			
			HttpSession ses         = request.getSession();
			CustomerAddress address = (CustomerAddress)ses.getAttribute("sesCosAddress");
			
			CountryData countryData = cd.getCountryById(Integer.parseInt(country));
			CityData    cityData    = cd.getCityById(Integer.parseInt(city));
			
			System.out.println("City Name :"+cityData.getCity());
			System.out.println("Address :"+address);
			
			address.setCity(cityData.getCity());
			address.setCountry(countryData.getCountry());
			address.setLocArea(area);
			
			cus.setCustomer(customer);
			cus.setEmail(email);
			cus.setPassword(password);
			cus.setPhone(phone);
			cus.setcNIC(cnic);
			cus.setDob(dob);
			cus.setGender(gender);
			cus.setAddress(address);
			
			System.out.println(cus);
			
			System.out.println(cus.getAddress());
			
			cdao.saveCustomer(cus);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			System.out.println("At Last else");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
			
		
	}

}
