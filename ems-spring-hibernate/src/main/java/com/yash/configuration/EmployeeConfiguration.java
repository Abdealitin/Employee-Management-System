package com.yash.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
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
}
