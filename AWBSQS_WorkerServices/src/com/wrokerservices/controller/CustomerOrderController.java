package com.wrokerservices.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workerservices.dao.WorkOrderDAO;
import com.workerservices.daoImplement.WorkOrderDAO_Implement;

/**
 * Servlet implementation class CustomerOrderController
 */
@WebServlet("/CustomerOrderController")
public class CustomerOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WorkOrderDAO orderDAO     =  new WorkOrderDAO_Implement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderController() {
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
		
		int oID       = Integer.parseInt(request.getParameter("orderID"));
		double rate   = Double.parseDouble(request.getParameter("rate"));
		String review = request.getParameter("review");
		String act    = request.getParameter("act") ;
		
		if(act.equalsIgnoreCase("cancel")){
			int row= orderDAO.customerOrderCancel(oID, rate, review);
			if(row>0){
				request.getRequestDispatcher("user_Profile.jsp").forward(request, response);
			}else{
				System.out.println("Some Error");
			}
		}else if(act.equalsIgnoreCase("complete")){
			int row= orderDAO.customerOrderRating(oID, rate, review);
			if(row>0){
				request.getRequestDispatcher("user_Profile.jsp").forward(request, response);
			}else{
				System.out.println("Some Error");
			}
		}
		
		
	}

}
