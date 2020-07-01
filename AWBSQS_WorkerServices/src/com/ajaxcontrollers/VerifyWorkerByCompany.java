package com.ajaxcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workerservices.dao.Company_DAO;
import com.workerservices.daoImplement.Company_DAO_Implement;
import com.workerservices.model.Company;
import com.workerservices.model.Worker;

/**
 * Servlet implementation class VerifyWorkerByCompany
 */
@WebServlet("/VerifyWorkerByCompany")
public class VerifyWorkerByCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Company_DAO cd       = new Company_DAO_Implement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyWorkerByCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		
		if(!(request.getSession().getAttribute("company") == null)){
			String workerID  = request.getParameter("wID");
			String companyID = request.getParameter("companyID");
			
			Company c        = (Company)request.getSession().getAttribute("company");
			
			int row = cd.verifyWorker(Integer.parseInt(workerID),Integer.parseInt(companyID));
			if(row>0){
				List<Worker> workerRequests =  cd.getWorkerRequests(c.getTrade().getId());
				out.println("<div class='panelfooter'>");
				out.println("<div class='panel-heading'>Requests For be a Worker</div>");
				out.println("<div class='panel-body'>");
				out.println("<table class='table'>");
				out.println("<tr>");
				out.println("<th>Worker ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>CNIC</th>");
				out.println("<th>Action</th>");
				out.println("</tr>");
				for(Worker wkr:workerRequests){
					out.println("<tr>");
					out.println("<td>"+wkr.getId()+"</th>");
					out.println("<td>"+wkr.getWorker()+"</th>");
					out.println("<td>"+wkr.getcNIC()+"</th>");
					out.println("<td><button onclick='verifyworker("+wkr.getId()+","+c.getId()+")' class='btn btn-success'>Approve Worker</button></th>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</div>");
				out.println("</div>");
			}
			
		}else{
			System.out.println("Company not Login");
		}
	}

}
