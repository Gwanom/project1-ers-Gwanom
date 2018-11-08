package com.revature.dao;

import java.util.List;

import com.revature.model.AppUser;

public interface UserDao {
	UserDao currentImplementation = new UserDaoJdbc();

	AppUser findById(int id);

	List<AppUser> findAll();

	AppUser findByUsernameAndPassword(String username, String password);

}
