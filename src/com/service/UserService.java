package com.service;

import com.dao.UsersDao;
import com.mod.bean.Users;

public class UserService {

	public static Users findUser(Users user){
		return UsersDao.findUser(user);
	}
	public static String addUser(Users user){
		
		return UsersDao.addUser(user);
	}
}
