package com.palvair.spring.mvc.form.security.annotations;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palvair.spring.mvc.form.security.annotations.cxf.WsClientFactory;
import com.palvair.spring.mvc.form.security.annotations.form.EmployeeForm;
import com.palvair.spring.mvc.form.security.annotations.model.Employee;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class EmployeeController {

	@Autowired
	private WsClientFactory factory;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees() {
		// TODO : implement list
		return "employees/list";
	}

	@RequestMapping(value = "/employees/add", method = RequestMethod.POST)
	public String newEmployee(@Valid @ModelAttribute(name = "employeeForm") EmployeeForm userForm,
			BindingResult bindingResult) {
		log.info("bindingResult =" + bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("errors = " + bindingResult.getAllErrors());
			return "employeeForm";
		}
		// TODO : save employee and get id
		Long id = 1L;
		return "redirect:/employees/" + id;
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public String newEmployee(@PathVariable("id") Long id, Model model) {
		Employee employee = factory.getEmployeeRecentClient().findById(id);
		model.addAttribute("employee", employee);
		// TODO : implement view
		return "employees/view";
	}

	@ModelAttribute(name = "employeeForm")
	public EmployeeForm employeeForm() {
		return new EmployeeForm();
	}
}
