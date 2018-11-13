package com.revature.dao;

import java.util.List;

import com.revature.model.AppUser;
import com.revature.model.Reimbursement;

public interface AppUserDao {
	AppUserDao currentImplementation = new AppUserDaoJdbc();

	AppUser findById(int id);

	List<AppUser> findAll();

	AppUser findByUsernameAndPassword(String username, String password);
	
	int postNewUser(AppUser au);
	
	List<Reimbursement> findReimbsByUser(int id);
	
	int postNewReimb(Reimbursement reim, int userid);
}
