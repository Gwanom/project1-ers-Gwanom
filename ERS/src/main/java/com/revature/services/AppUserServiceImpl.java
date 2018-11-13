package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.AppUserDao;
import com.revature.dto.Credential;
import com.revature.model.AppUser;
import com.revature.model.Reimbursement;

public class AppUserServiceImpl implements AppUserService {
	private AppUserDao aud = AppUserDao.currentImplementation;

	@Override
	public AppUser findById(int id) {
		return aud.findById(id);
	}

	@Override
	public List<AppUser> findAll() {
		return aud.findAll();
	}

	@Override
	public boolean login(Credential cred, HttpSession session) {
		AppUser u = aud.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());
		if (u != null) {
			session.setAttribute("role", u.getRole());
			return true;
		}
		return false;
	}
	
	public int postNewUser(AppUser au) {
		return aud.postNewUser(au);
	}
	
	public List<Reimbursement> findReimbsByUser(int id){
		return aud.findReimbsByUser(id);
	}
	
	public int postNewReimb(Reimbursement reim, int userid) {
		return aud.postNewReimb(reim, userid);
	}
}
