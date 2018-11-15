package com.revature.services;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementService {
	
	ReimbursementService currentImplementation = new ReimbursementServiceImpl();

	Reimbursement findById(int id);
	
	List<Reimbursement> findByStatusId(int id);
	
	List<Reimbursement> findAll();
	
	int updateReimbursement(int reimbId, int statusId);
}
