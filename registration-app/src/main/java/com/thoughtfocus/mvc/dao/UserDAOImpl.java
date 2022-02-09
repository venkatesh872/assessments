package com.thoughtfocus.mvc.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thoughtfocus.mvc.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveUser(UserDTO user) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();

			transaction.rollback();

		} finally {

			session.close();

		}
		return true;

	}

	@Override
	public List<UserDTO> fetchAllUsers() {
		Session session = null;
		String hql = "SELECT user FROM UserDTO user";
		Query query;
		List<UserDTO> dto = null;
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			dto = (List<UserDTO>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return dto;
	}

	@Override
	public boolean getByUserNameAndPassword(String username, String password) {

		String hql = "SELECT user FROM UserDTO user WHERE username=:name AND password =:pwd";
		Session session = null;
		Transaction transaction = null;
		Query query;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			query.setParameter("name", username);
			query.setParameter("pwd", password);
		    query.uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
			return false;
	}

	@Override
	public boolean update(String username, Long mobileNumber) {
		String updatemobilenumberbyusernamequery = "UPDATE UserDTO SET mobileNumber=:numb WHERE username =:nme";
		Session session = null;
		Transaction transaction = null;
		Query query;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			query = session.createQuery(updatemobilenumberbyusernamequery);
			query.setParameter("nme", username);
			query.setParameter("numb", mobileNumber);
		    query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} finally {
			if (session != null)
				session.close();
		}
			return true;
	}

	@Override
	public boolean delete(String username, Long mobileNumber, Double age) {
		String deleteusernameBymobilenumberandagequery = "DELETE FROM UserDTO WHERE username =:nme AND mobileNumber=:mn AND age=:age";
		Session session = null;
		Transaction transaction = null;
		Query query;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			query = session.createQuery(deleteusernameBymobilenumberandagequery);
			query.setParameter("nme", username);
			query.setParameter("mn", mobileNumber);
			query.setParameter("age", age);
		    query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} finally {
			if (session != null)
				session.close();
		}
			return true;
	}

	
	
	
	
}
