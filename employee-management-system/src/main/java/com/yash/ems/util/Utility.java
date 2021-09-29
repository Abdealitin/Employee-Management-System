package com.yash.ems.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Utility {
	public static SessionFactory getSF() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		return sessionFactory;
	}
}
