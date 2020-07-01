package com.workerservices.dao;

import java.util.List;

import com.workerservices.model.Customer;
import com.workerservices.model.Trade;
import com.workerservices.model.Worker;
import com.workerservices.model.WorkerAddress;


public interface Worker_DAO {
	
	Trade             getTradeByID(int id);
	WorkerAddress     getAddressByID(int id);
	
	List<Trade>       getAllTrades();
	List<Worker>      getAllWorkers();
	List<Worker>      getVarifiedWorkers();
	List<Worker>      getAllunbookedWorkers(int cID);
	
	Worker            getWorkerById(int id);
	Worker            getWorkerByEmail(String email);
	
	boolean           isBookedbyCustomer(int cID,int wID);
	
	int registratorWorker(Worker w);
	int saveAddress(WorkerAddress address);

}
