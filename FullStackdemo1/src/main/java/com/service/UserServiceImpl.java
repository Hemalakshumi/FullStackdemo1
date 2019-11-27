package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public User createUser(User user) {
	
	
		User user1=null;
		if(user.getPassword().length()>3)
		{
			user1=this.userDao.createUser(user);
		}
		return user1;
	}

	@Override
	public List<User> readUser() {
		// TODO Auto-generated method stub
		return this.userDao.readUser();
	}


	@Override
	public User readUserById(int userId) {
		
		return this.userDao.readUserById(userId);
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		
		
		return this.userDao.updateUser(user);
	}

	@Transactional
	@Override
	public User deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return  this.userDao.deleteUserById(userId);
	}

}
