package com.ajaxcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workerservices.dao.WorkOrderDAO;
import com.workerservices.daoImplement.WorkOrderDAO_Implement;
import com.workerservices.daoImplement.Worker_DAO_Implement;
import com.workerservices.model.WorkOrders;

/**
 * Servlet implementation class OrderControllerAjax
 */
@WebServlet("/OrderControllerAjax")
public class OrderControllerAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	WorkOrderDAO workorderdao = new WorkOrderDAO_Implement(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderControllerAjax() {
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
		int oID = Integer.parseInt(request.getParameter("oID"));
		int wID = Integer.parseInt(request.getParameter("wID"));
		
		System.out.println(oID);
		System.out.println(wID);
		int row = workorderdao.orderComplete(oID,wID);
		
		
		if(row>0){
			List<WorkOrders> ordrs = workorderdao.getOrdersByWorkerID(wID);
			
				out.print("<table class='table table-hover'>");
				out.print("<thead>");
				out.print("<tr>");
				out.print("	<th>Customer</th>");
				out.print("	<th>Order Time</th>");
				out.print("	<th>Order Date</th>");
				out.print("	<th>Order Status</th>");
				out.print("	<th>Action</th>");
				out.print("</tr>");
				out.print("</thead>");
				out.print("<tbody>");
				for (WorkOrders wo : ordrs) {	
					out.print("<tr>");
					out.print("<td>"+wo.getCostumer().getCustomer()+"</td>");
					out.print("<td>"+wo.getTime()+"</td>");
					out.print("<td>"+wo.getDate()+"</td>");
					out.print("<td>"+wo.getOrderStatus()+"</td>");
					out.print("<td><button onclick='completeOrder("+wo.getId()+","+wID+")' class='btn btn-success'>Complete</button></td>");
					out.print("</tr>");
				}
				out.print("</tbody>");
				out.print("<tfoot>");
				out.print("<center><button data-toggle='modal' data-target='#mod' class='btn btn-success'>View Locations</button></center>");
				out.print("</tfoot>");
				out.print("</table>");
			}else{
				System.out.println("Error Went Wrong");
		    }
	}

}
