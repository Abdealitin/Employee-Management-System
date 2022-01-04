package com.yash.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Abdeali Tinwala
 *  App Initializer class to configure properties on startup
 */
public class EmployeeIntializer implements WebApplicationInitializer {

	/**
	 *Configuring the dispatcher servlet on initialization of app  
	 */
	@Override
	public void onStartup(ServletContext context) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(EmployeeConfiguration.class);
		ctx.setServletContext(context);
		ServletRegistration.Dynamic servlet=context.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
