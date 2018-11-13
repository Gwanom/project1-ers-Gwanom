package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.Credential;
import com.revature.model.AppUser;
import com.revature.model.Reimbursement;

public interface AppUserService {
	AppUserService currentImplementation = new AppUserServiceImpl();

	AppUser findById(int id);

	List<AppUser> findAll();

	boolean login(Credential cred, HttpSession httpSession);
	
	int postNewUser(AppUser au);
	
	List<Reimbursement> findReimbsByUser(int id);
	
	int postNewReimb(Reimbursement reim, int userid);
}
