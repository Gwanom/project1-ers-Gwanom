package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	private ReimbursementDao rd = ReimbursementDao.currentImplementation;
	
	@Override
	public Reimbursement findById(int id) {
		return rd.findById(id);
	}

	@Override
	public List<Reimbursement> findByStatusId(int id) {
		return rd.findByStatusId(id);
	}

	@Override
	public List<Reimbursement> findAll() {
		return rd.findAll();
	}

	@Override
	public int updateReimbursement(Reimbursement reim) {
		return rd.updateReimbursement(reim);
	}

}
