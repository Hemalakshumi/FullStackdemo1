package com.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;



@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User createUser(User user) {
		Session session =this.sessionFactory.openSession();
		session.save(user);
		return user;
	}

	@Override
	public List<User> readUser() {
		Session session =this.sessionFactory.openSession();
		//HQL
		String readUser ="from User";
		List<User> users=session.createQuery(readUser).list();
		return users;
	}

	@Override
	public User readUserById(int userId) {
		Session session =this.sessionFactory.openSession();
		String hqlRead ="from User alias where alias.userId =:id";
		List<User> users=session.createQuery(hqlRead).setParameter("id",1).list();
		return users.get(0);
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		Session session =this.sessionFactory.openSession();
		session.saveOrUpdate(user);
		return user;
	}

	@Override
	public User deleteUserById(int userId) {
		Session session =this.sessionFactory.openSession();
		//session.load(User.class,new Integer(userId));
		//auto boxing
		User user=session.load(User.class, userId);
		session.delete(user);
		
		return user;
	}

}
