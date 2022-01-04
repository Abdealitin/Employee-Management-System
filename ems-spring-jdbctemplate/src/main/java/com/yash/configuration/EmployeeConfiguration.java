package com.yash.configuration;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Abdeali Tinwala
 * Configuration class for the Employee App
 *
 */
@Configuration
@ComponentScan(basePackages = "com.yash")
@PropertySource("classpath:application.properties")
public class EmployeeConfiguration implements WebMvcConfigurer{
	
	/**
	 * Injecting the Environment variable which provides the properties from properties file 
	 */
	@Autowired
	Environment environment;
	
	/**
	 * Declaring JDBC URL, database user name, password and driver 
	 */
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	/**
	 * @return Driver Manager DataSource variable which contains the data for establish jdbc Connection
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
	/**
	 * @return View Resolver variable which contains the data about the configuration of views
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
}
