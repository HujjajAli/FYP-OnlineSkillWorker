package com.ajaxcontrollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workerservices.model.CustomerAddress;
import com.workerservices.model.WorkerAddress;

/**
 * Servlet implementation class SetMyLocation
 */
@WebServlet("/SetMyLocation")
public class SetMyLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetMyLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
	   String locEvent       = request.getParameter("loc");
	   String latitude  = 	request.getParameter("latV");
	   String longitude =	request.getParameter("longV");
	   
	   System.out.println(latitude);
	   System.out.println(longitude);
	   HttpSession sess = request.getSession();
	   if(locEvent.equals("user")){
	   
		   String loc = latitude+","+longitude;
		   CustomerAddress sesCosAddress = new  CustomerAddress();
		   sesCosAddress.setLocation(loc);
		   
		   sess.setAttribute("sesCosAddress", sesCosAddress);
		   System.out.println("Set Address :"+sesCosAddress);
	   }else if(locEvent.equals("worker")){
		   String loc = latitude+","+longitude;
		   System.out.println(loc);
		   WorkerAddress sesWorkerAddress = new WorkerAddress();
		   sesWorkerAddress.setLocation(loc);
		   sesWorkerAddress.setMapLocation(loc);
		   
		   
		   sess.setAttribute("sesWorkerAddress", sesWorkerAddress);
	   }else if(locEvent.equals("company")){
		   //sess.s
		   //Company
	   }
	}

}
