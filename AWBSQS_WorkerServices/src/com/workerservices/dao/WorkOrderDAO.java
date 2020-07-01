package com.workerservices.dao;

import java.util.List;

import com.workerservices.model.WorkOrders;

public interface WorkOrderDAO {
	
	List<WorkOrders> getOrdersByWorkerID(int wID);
	List<WorkOrders> getOrdersByCustomerID(int cID);
	List<WorkOrders> getGetReviewsByWorkerId(int wid);
	
	int hireWorker(WorkOrders ord);
	int orderComplete(int oID,int wID);
	int customerOrderRating(int oID,double rate,String review);
	int customerOrderCancel(int oID,double rate,String review);
	
	void updateWorkerRating(int wID); 
}
