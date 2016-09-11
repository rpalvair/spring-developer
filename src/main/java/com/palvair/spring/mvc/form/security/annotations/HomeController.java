package com.palvair.spring.mvc.form.security.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
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
