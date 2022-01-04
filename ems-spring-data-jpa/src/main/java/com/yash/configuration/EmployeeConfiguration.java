package com.yash.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Abdeali Tinwala
 * Configuration Class for project which implementing WebMvcConfigurer
 * which defines options for customizing or adding to the default Spring MVC configuration
 */
@Configuration
@EnableTransactionManagement          // this tells Spring Data JPA to generate code for transaction management at runtime.
@EnableJpaRepositories("com.yash")   // this tells Spring Data JPA to look for repository classes in the specified package in order to inject relevant code at runtime.
@ComponentScan(basePackages = "com.yash")
@PropertySource("classpath:database.properties")    //To find the database properties file
public class EmployeeConfiguration {

	@Autowired
	Environment environment;
	
	private final String PROPERTY_DRIVER = "driver";
	private final String PROPERTY_URL = "url";
	private final String PROPERTY_USERNAME = "user";
	private final String PROPERTY_PASSWORD = "password";
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	
	/**
	 * @return InternalResourceViewResolver Object
	 * helps in mapping the logical view names to directly view files
	 * under a pre-configured directory.
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	/**
	 * @return ResourceBundleMessageSource 
	 * accesses resource bundles using specified base names (here it is messages).
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		//Specify data source that will be used by JPA persistence API.
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistence.class);
		//Specify the package name that contains JPA entities.
		lfb.setPackagesToScan("com.yash.model");
		//Specify JPA properties that will be passed to method that creates entity manager factory
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}
	
	/**
	 * Simple implementation of the standard JDBC javax.sql.DataSource interface,
	 * configuring the plain old JDBC java.sql.DriverManager via bean properties.
	 * @return data source
	 */
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(environment.getProperty(PROPERTY_URL));
		ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
		ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
		ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
		return ds;
	}
	
	/**
	 * Setting the properties for hibernate to provide the JPA
	 * @return properties
	 */
	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		return properties;
	}
	
	/**
	 * @return JpaTransactionManager is appropriate for single JPA EntityManagerFactory for transactional data access.
	 */
	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
