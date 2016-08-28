package com.palvair.spring.mvc.form.security.annotations.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.palvair.spring.mvc.form.security.annotations.MvcConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfig.class)
@WebAppConfiguration
@Log4j
public class RestControllerIT {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void postJson() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		RestRequest restRequest = new RestRequest();
		restRequest.setContent("Hello World");
		mockMvc.perform(
				post("/json").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(restRequest)))
				.andExpect(status().isOk()).andDo((MvcResult result) -> {
					log.info("response = " + result.getResponse().getContentAsString());
				});

	}

	@Test
	public void postJsonWithNullContent() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		RestRequest restRequest = new RestRequest();
		restRequest.setContent(null);
		mockMvc.perform(
				post("/json").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(restRequest)))
				.andExpect(status().isBadRequest()).andDo((MvcResult result) -> {

					log.info("response = " + result.getResponse().getContentAsString());
				});

	}
}
