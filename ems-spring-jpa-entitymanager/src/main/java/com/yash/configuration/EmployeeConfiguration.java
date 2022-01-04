package com.yash.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Abdeali Tinwala
 * Configuration Class for project which implementing WebMvcConfigurer
 * which defines options for customizing or adding to the default Spring MVC configuration
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yash")
@EnableTransactionManagement                     //enables annotation-driven transaction management capability.
@PropertySource("classpath:database.properties")
public class EmployeeConfiguration implements WebMvcConfigurer {

	/**
	 * @return InternalResourceViewResolver Object
	 * helps in mapping the logical view names to directly view files
	 * under a pre-configured directory.
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
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

	/**
	 * @return Validator Object 
	 * which is used for bootstrapping validations
	 */
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Autowired
	private Environment env;	
	
	
	/**
	 * It creates a JPA EntityManagerFactory according to the standard container bootstrap contract of JPA. 
	 * In this way we get a shared EntityManagerFactory in our spring application context.
	 * To use it in DAO we just do dependency injection to get its instance.
	 * To create entity manager factory bean we specify the values to setter methods.
	 * @return Enity Manager Factory Bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
		//Specify data source that will be used by JPA persistence API.
		lcemfb.setDataSource(getDataSource());
		//This is the default persistence unit name.
		lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
		//Specify the package name that contains JPA entities.
		lcemfb.setPackagesToScan("com.yash");
		//Specify JPA properties that will be passed to method that creates entity manager factory
		lcemfb.setJpaProperties(jpaProperties());
		return lcemfb;
	}
	/**
	 * @return JPAVendorAdapter
	 * HibernateJpaVendorAdapter which is the implementation of JpaVendorAdapter
	 * that will facilitate to get hibernate EntityManager.
	 */
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}
	/**
	 *  Creating data source using BasicDataSource class from the commons.dbcp2 library. 
	 *  Using this class we configure database driver class name, URL, username and password.
	 * @return data source
	 */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.username"));
		dataSource.setPassword(env.getProperty("database.password"));
		return dataSource;
	}
	/**
	 * @return JpaTransactionManager is appropriate for single JPA EntityManagerFactory for transactional data access.
	 */
	@Bean
	public PlatformTransactionManager txManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}
	
	/**
	 * Providing hibernate properties to JPA
	 * @return properties
	 */
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		return properties;        
	}
}
