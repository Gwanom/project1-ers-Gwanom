package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	ReimbursementDao currentImplementation = new ReimbursemenDaoJdbc();
	
	Reimbursement findById(int id);
	
	List<Reimbursement> findByStatusId(int id);
	
	List<Reimbursement> findAll();
	
	int updateReimbursement(Reimbursement reim);
}
