package com.workerservices.dao;

import java.util.List;

import com.workerservices.model.CityData;
import com.workerservices.model.Company;
import com.workerservices.model.CountryData;
import com.workerservices.model.Trade;
import com.workerservices.model.Worker;

public interface Company_DAO {
	
	List<Company>      getAllCompanies();
	List<Worker>       getWorkerRequests(int company);
	
	Company getCompanyByEmail(String email);
	int saveCompany(Company cmp);
	int verifyWorker(int workerID,int companyID);
	
	int numberofCompanyWorkers(int tid);
	int numberOfRequestforTrade(int tid);
	int numberOforders(int cid);
	int numberOfPandingOrders(int cid);
	 
	
	List<CountryData>  getCountryData();
	List<CityData>     getCityDataByCountryId(int id);
	List<CityData>     getCityData();
	List<Worker>       getCompanyWorkers();
	List<Integer>      getVarifiedWorkers(int id);
	
	CityData     getCityById(int id);
	CountryData  getCountryById(int id);
	Trade        getCompanyTradeById(int id);
	
}
