package com.yash.configuration;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Abdeali Tinwala
 *	Configuration class for Hibernate
 */
@Configuration
@EnableTransactionManagement              //enables Spring’s annotation-driven transaction management capability.
public class HibernateConfiguration {
	
	/**
	 * Injecting the application context object to fetch resources and beans
	 */
	@Autowired
    private ApplicationContext context;
 
    /**
     * @return LocalSessionFactoryBean creates a Hibernate SessionFactory
     */
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = new Properties();
        // Setting JDBC properties
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/springdb");
        props.put("hibernate.connection.username", "root");
        props.put("hibernate.connection.password", "root");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", true);
        
        //Setting C3P0 properties
        props.put("hibernate.connection.provider_class", "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.yash.model");
        return factoryBean;
    }
 
    /**
     * @return HibernateTransactionManager binds a Hibernate Session from the specified factory
     * which specifies Session per Factory
     */
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
    
}
