package com.yash.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataUtility {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	
	private static SessionFactory buildSessionFactory() {

		try {
			Configuration config=new Configuration().configure();
			SessionFactory sessionFactory=config.buildSessionFactory();
			return sessionFactory;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("SessionFactory Creation Failed ");
		}
	}
	@Bean
	public Session getSession(){
		return DataUtility.sessionFactory.openSession();
	}
}
