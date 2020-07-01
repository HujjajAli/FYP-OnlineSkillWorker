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
import com.workerservices.model.CityData;

/**
 * Servlet implementation class GetAddressDataService
 */
@WebServlet("/GetAddressDataService")
public class GetAddressDataService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Company_DAO cd = new Company_DAO_Implement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddressDataService() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String cidstr = request.getParameter("cid");
		int cidInt    =  Integer.parseInt(cidstr);
		List<CityData> cityD = cd.getCityDataByCountryId(cidInt);
		out.print("<option value='0'>Select Your City</option>");
		for (CityData cityData : cityD) {
			out.print("<option value='"+cityData.getId()+"'>"+cityData.getCity()+"</option>");
		}
		
		
	}

}
