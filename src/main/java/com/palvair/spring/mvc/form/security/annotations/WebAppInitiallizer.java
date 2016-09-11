package com.palvair.spring.mvc.form.security.annotations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import lombok.extern.log4j.Log4j;

@Log4j
public class WebAppInitiallizer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		
		 // Create the 'root' Spring application context
	      AnnotationConfigWebApplicationContext rootContext =
	        new AnnotationConfigWebApplicationContext();
	      rootContext.register(ApplicationConfig.class);

	      // Manage the lifecycle of the root application context
	      container.addListener(new ContextLoaderListener(rootContext));

	      // Create the dispatcher servlet's Spring application context
	      AnnotationConfigWebApplicationContext dispatcherContext =
	        new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(MvcConfig.class);

	      // Register and map the dispatcher servlet
	      ServletRegistration.Dynamic dispatcher =
	        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("/");
	      
	      ServletRegistration.Dynamic cxf =
	  	        container.addServlet("cxfServlet", new CXFServlet());
	  	      cxf.setLoadOnStartup(2);
	  	      cxf.addMapping("/cxf/*");
	      
		
	      log.info("application started");
	}

}
