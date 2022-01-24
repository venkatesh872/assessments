package com.thoughtfocus.movie.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HybernateUtil {
	private static final SessionFactory sessionFactory;

	private HybernateUtil() {}
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory =cfg.buildSessionFactory();
	}
		
	public static SessionFactory getSessionFactory() {
			
		return sessionFactory;
		
	}
	
}
