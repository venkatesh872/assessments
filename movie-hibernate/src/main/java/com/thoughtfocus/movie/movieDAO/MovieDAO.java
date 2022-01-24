package com.thoughtfocus.movie.movieDAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thoughtfocus.movie.hibernateUtil.HybernateUtil;
import com.thoughtfocus.movie.movieDTO.MovieDTO;

public class MovieDAO {
	public void saveMovie(MovieDTO dto) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory= HybernateUtil.getSessionFactory();
			session =sessionFactory.openSession();
			transaction= session.beginTransaction();
			session.save(dto);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}
}
