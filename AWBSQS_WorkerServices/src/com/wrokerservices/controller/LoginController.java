package com.wrokerservices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workerservices.dao.Company_DAO;
import com.workerservices.dao.Customer_DAO;
import com.workerservices.dao.WorkOrderDAO;
import com.workerservices.dao.Worker_DAO;
import com.workerservices.daoImplement.Company_DAO_Implement;
import com.workerservices.daoImplement.Customer_DAO_Implement;
import com.workerservices.daoImplement.WorkOrderDAO_Implement;
import com.workerservices.daoImplement.Worker_DAO_Implement;
import com.workerservices.model.Company;
import com.workerservices.model.Customer;
import com.workerservices.model.WorkOrders;
import com.workerservices.model.Worker;
import com.workerservices.model.WorkerAddress;
import com.wrokerservices.db.DBHandler;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Worker_DAO wd        = new Worker_DAO_Implement();
	Company_DAO cd       = new Company_DAO_Implement();
	Customer_DAO csd     = new Customer_DAO_Implement();
	WorkOrderDAO workdoa = new WorkOrderDAO_Implement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String login_user = request.getParameter("login_user");
		
		request.setAttribute("workers",wd.getAllWorkers());
		request.setAttribute("companies",cd.getAllCompanies());
		request.setAttribute("customers",csd.getAllCustomer());
		
		if(login_user == null){               //see if login_user parameter does have a value if not show login page
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			                                 // if user in login see which one wants to login
			
			if(login_user.equalsIgnoreCase("worker")){
			
			
				String email    = request.getParameter("email");
				Worker worker   = wd.getWorkerByEmail(email);
				String password = request.getParameter("password");
				
				if(worker == null){
					request.getRequestDispatcher("worker_Registration.jsp").forward(request, response);
				}else{
					
					if(worker.getPassword().equalsIgnoreCase(password)){     //if worker entered password is equal to saved password 
						
						HttpSession ses = request.getSession();
						
						WorkerAddress workeraddress = worker.getAddress();         //getting Worker Address from get Methode
						workeraddress.setLocation(workeraddress.getMapLocation()); //setting Longititude and Letitude for google map
						
						List<WorkOrders> workorders = workdoa.getOrdersByWorkerID(worker.getId());
						
						request.setAttribute("workeraddress", workeraddress);
						request.setAttribute("pandingOrders", workorders);
						ses.setAttribute("wkr", worker);
						
						request.getRequestDispatcher("worker_Dashboard.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				}
			
			}else if(login_user.equalsIgnoreCase("company")){
				String email    = request.getParameter("email");
				String password = request.getParameter("password");
				Company company = cd.getCompanyByEmail(email);
				
				if(company == null){
					request.getRequestDispatcher("company_Registration.jsp").forward(request, response);
				}else{
					
					if(company.getPassword().equalsIgnoreCase(password)){  //if company entered password is equal to saved password
						request.getSession().setAttribute("company", company);
						
						System.out.println(company.getCompany());
						
						request.getRequestDispatcher("company_Dashboard.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				}
				
				
				
			}else if(login_user.equalsIgnoreCase("member")){
				String email    = request.getParameter("email");
				String password = request.getParameter("password");
				Customer cus =  csd.getCustoemerByEmail(email);
				
				HttpSession ses = request.getSession();
				if(cus == null){
					request.getRequestDispatcher("user_Registration.jsp").forward(request, response);
				}else{
					if(cus.getPassword().equalsIgnoreCase(password)){
						ses.setAttribute("login_customer", cus);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				//http://localhost:8082/AWBSQS_WorkerServices/index.jsp
				
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
	}

}
