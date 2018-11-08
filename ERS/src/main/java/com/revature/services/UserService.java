package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.Credential;
import com.revature.model.AppUser;

public interface UserService {
	UserService currentImplementation = new UserServiceImpl();

	AppUser findById(int id);

	List<AppUser> findAll();

	boolean login(Credential cred, HttpSession httpSession);

}
