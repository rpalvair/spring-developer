package com.palvair.spring.mvc.form.security.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palvair.spring.mvc.form.security.annotations.service.UsersService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		try {
			usersService.incrementAge(false);
		} catch (Exception e) {
			log.error(e);
		}
		return "index";
	}

	@RequestMapping(value = "/internal", method = RequestMethod.GET)
	public String internal() {
		return "internal";
	}
	
	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	public String xml() {
		return "xml";
	}
	
	@RequestMapping(value = "/bundle", method = RequestMethod.GET)
	public String bundle() {
		return "bundle";
	}
}
