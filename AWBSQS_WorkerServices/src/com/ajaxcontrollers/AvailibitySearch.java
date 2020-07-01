package com.ajaxcontrollers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvailibitySearch
 */
@WebServlet("/AvailibitySearch")
public class AvailibitySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailibitySearch() {
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
		out.println("Search");
		
		String date        = request.getParameter("date");
		String frmHour     = request.getParameter("frmHour");
		String frmMinutes  = request.getParameter("frmMinutes");
		String ToHour      = request.getParameter("ToHour");
		String ToMinutes   = request.getParameter("ToMinutes");
		
		System.out.println("Select Date  "+date);
		System.out.println("Select FHour "+frmHour);
		System.out.println("Select FMin  "+frmMinutes);
		System.out.println("Select THour "+ToHour);
		System.out.println("Select ToMin "+ToMinutes);
	}

}
