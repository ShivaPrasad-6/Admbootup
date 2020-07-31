package com.david.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.airline.dao.UserDao;
import com.david.airline.entity.User;

@Service
public class UserService {	
	
	@Autowired
	UserDao userDao;
	
	public void registerForm(User user) {
		userDao.save(user);
	}
	
	
	public User findByUserName(String userName){
		return userDao.findByUserName(userName);
	}

}
