package com.cognizant;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * extends SpringBootServletInitializer which is an opinionated
 * WebApplicationInitializer to run a SpringApplication from a traditional WAR
 * deployment
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * to configure the application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IpTreatmentWebPortalApplication.class);
	}

}
