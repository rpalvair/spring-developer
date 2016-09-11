package com.palvair.spring.mvc.form.security.annotations;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.palvair.spring.mvc.form.security.annotations.cxf.WsEmployeeService;
import com.palvair.spring.mvc.form.security.annotations.cxf.WsEmployeeServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public TilesViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(0);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/tiles-definitions.xml");
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		return internalResourceViewResolver;

	}

	@Bean
	public XmlViewResolver xmlViewResolver() {
		XmlViewResolver xmlViewResolver = new XmlViewResolver();
		xmlViewResolver.setLocation(new ClassPathResource("views.xml"));
		xmlViewResolver.setOrder(2);
		return xmlViewResolver;
	}

	@Bean
	public ResourceBundleViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver resourceBundleViewResolver = new ResourceBundleViewResolver();
		resourceBundleViewResolver.setBasename("views");
		resourceBundleViewResolver.setOrder(3);
		return resourceBundleViewResolver;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean
	public WsEmployeeService employeeService() {
		return new WsEmployeeServiceImpl();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(cxf(), employeeService());
		endpoint.publish("/employees");
		// endpoint.setWsdlLocation("...");
		endpoint.setAddress("/employees");
		return endpoint;
	}

}
