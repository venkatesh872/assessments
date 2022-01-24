package com.thoughtfocus.movie.moviehqlDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.thoughtfocus.movie.hibernateUtil.HybernateUtil;

public class MovieHqlDAO {

	public Double getBudgetByName(String name) {
		String select = "SELECT budget FROM MovieDTO WHERE name=:name";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		Double budget = null;

		try {
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			query.setParameter("name", name);
			budget = (Double) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return budget;

	}

	public Object[] getLanguageAndActorById(int i) {
		String select = "SELECT language,noOfActor FROM MovieDTO WHERE id=:id";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		Object[] obj = null;

		try {
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			query.setParameter("id", i);
			obj = (Object[]) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return obj;

	}


	public Boolean getColorByNameAndLanguage(String name, String language) {
		String select = "SELECT isColor FROM MovieDTO WHERE name=:nm and language=:lng";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		Boolean obj = null;

		try {
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			query.setParameter("nm", name);
			query.setParameter("lng", language);
			obj = (Boolean) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return obj;
	}

	
	public List<Object[]> getNameAndBudgetByLanguage(String language) {
		String select = "SELECT name,budget FROM MovieDTO WHERE language=:lng";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		List<Object[]> obj = null;

		try {
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			query.setParameter("lng", language);
			obj =  query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return obj;

	}
	
	public List<Object[]> getAllMovies() {
		String select = "SELECT Movie FROM MovieDTO as Movie";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		List<Object[]> list = null;

		try {
			
			
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			list = query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return list;
	}

	public List<Object[]> getAllColorMovies() {
		String select = "SELECT Movie FROM MovieDTO as Movie WHERE isColor=true";

		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session = null;
		Query query;
		List<Object[]> list = null;

		try {
			session = sessionFactory.openSession();

			query = session.createQuery(select);

			list =  query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return  list;

	}
	
	public void updateBudgetById(int id,double budget) {
		String updatebudget ="UPDATE MovieDTO SET budget=:bud WHERE id=:id";
		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session=null;
		Transaction tx=null;
		Query query;
		try {
			session =sessionFactory.openSession();
			tx= session.beginTransaction();
			query = session.createQuery(updatebudget);
			query.setParameter("id", id);
			query.setParameter("bud", budget);
			query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		
		
	}
	public void updateColorByNameAndBudget(String name,double budget,boolean isColor) {
		String updatecolor ="UPDATE MovieDTO SET isColor=:col WHERE name=:nme AND budget=:bud";
		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session =null;
		Transaction tx=null;
		Query query;
		
		try {
			session =sessionFactory.openSession();
			tx= session.beginTransaction();
			query=session.createQuery(updatecolor);
			query.setParameter("nme", name);
			query.setParameter("bud", budget);
			query.setParameter("col", isColor);
			query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}
	public void updateNoOfActorsByNameBudgetAndLanguage(String name,double budget,String language,int noOfActor) {
		String updatenoofactors ="UPDATE MovieDTO SET noOfActor=:noact WHERE name=:nme AND budget=:bud AND language=:lng";
		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session =null;
		Transaction tx=null;
		Query query;
		try {
			session =sessionFactory.openSession();
			tx= session.beginTransaction();
			
			query = session.createQuery(updatenoofactors);
			query.setParameter("nme", name);
			query.setParameter("bud", budget);
			query.setParameter("lng", language);
			query.setParameter("noact", noOfActor);
			query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}
	public void deleteById(int id) {
		String deletebyid ="DELETE FROM MovieDTO  WHERE id=:id";
		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session =null;
		Transaction tx=null;
		Query query;
		try {
			session =sessionFactory.openSession();
			tx= session.beginTransaction();
	
			query = session.createQuery(deletebyid);
			query.setParameter("id", id);
			
			query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}
	public void deleteByColorAndActorCountlessThan15(boolean isColor) {
		String deletebyid ="DELETE FROM MovieDTO  WHERE isColor=:col AND noOfActor<15";
		SessionFactory sessionFactory = HybernateUtil.getSessionFactory();
		Session session =null;
		Transaction tx=null;
		Query query;
		try {
			session =sessionFactory.openSession();
			tx= session.beginTransaction();
			
			query = session.createQuery(deletebyid);
			query.setParameter("col", isColor);
			
			query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}
	

}