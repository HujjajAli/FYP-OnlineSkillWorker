package com.ajaxcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workerservices.dao.Customer_DAO;
import com.workerservices.dao.WorkOrderDAO;
import com.workerservices.dao.Worker_DAO;
import com.workerservices.daoImplement.Customer_DAO_Implement;
import com.workerservices.daoImplement.WorkOrderDAO_Implement;
import com.workerservices.daoImplement.Worker_DAO_Implement;
import com.workerservices.model.Customer;
import com.workerservices.model.WorkOrders;
import com.workerservices.model.Worker;

/**
 * Servlet implementation class HireWorkerService
 */
@WebServlet("/HireWorkerService")
public class HireWorkerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Worker_DAO wdoa      = new Worker_DAO_Implement();
    Customer_DAO cdao    = new Customer_DAO_Implement();  
    WorkOrderDAO ord_dao = new WorkOrderDAO_Implement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HireWorkerService() {
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
		if(!(request.getSession().getAttribute("login_customer") == null)){
			System.out.println("at Hire Worker");
			System.out.println("Worker "+request.getParameter("wID"));
			System.out.println("Customer "+request.getParameter("userID"));
			
			Worker wkr  = wdoa.getWorkerById(Integer.parseInt(request.getParameter("wID")));
			Customer cus = cdao.getCustoemerById(Integer.parseInt(request.getParameter("userID")));
			Date date = new Date();
			String time    = date.getHours()+":"+date.getMinutes();
			String strDate = date.toGMTString();
			String dateDate[] = strDate.split(" ");
			strDate = dateDate[0]+"/"+dateDate[1]+"/"+dateDate[2];
			
			System.out.println(wkr);
			System.out.println(cus);
			String logMSG = "<h5>Worker Has been Hired</h5>"
					+ "<br>Name :"+wkr.getWorker()+""
					+ "<br>Trade: "+wkr.getTrade().getTrade()+""
					+ "<br>Today Date : "+strDate+""
					+ "<br>Time : "+time;
			System.out.println("Time :"+time);
			System.out.println("Date :"+strDate);
			System.out.println(logMSG);
			
			String cdate        = request.getParameter("date");
			String frmHour     = request.getParameter("frmHour");
			String frmMinutes  = request.getParameter("frmMinutes");
			String ToHour      = request.getParameter("ToHour");
			String ToMinutes   = request.getParameter("ToMinutes");
			
			if(frmMinutes.equals("0")){
				frmMinutes = frmMinutes+"0";
			}
			
			if (ToMinutes.equals("0")) {
				ToMinutes = ToMinutes + "0";
			}
			
			logMSG += "<br><br>Selected Date:"+cdate;
			//logMSG += "From Hour   :"+frmHour;
			logMSG += "<br>From => :"+frmHour+":"+frmMinutes;
		//	logMSG += "To Hour     :"+ToHour;
			logMSG += "<br>To =>  "+ToHour+":"+ToMinutes;
			
			WorkOrders order = new WorkOrders();
			order.setCostumer(cus);
			order.setWorker(wkr);
			order.setTime(time);
			order.setDate(strDate);
			order.setPWODate(cdate);
			order.setPWOFromTime(frmHour+":"+frmMinutes);
			order.setPWOToTime(ToHour+":"+ToMinutes);
			order.setOrderStatus("Panding");
			
			
			int row = ord_dao.hireWorker(order);
			if(row>0){
				out.print(logMSG);
			}else{
				out.print("Some Error While Hiring Worker");
			}
			
		}else{
			out.println("User not Login");
		}
	}

}
