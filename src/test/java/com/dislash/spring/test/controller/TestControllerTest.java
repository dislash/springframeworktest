package com.dislash.spring.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TestControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void slashへのGET() throws Exception {
		mockMvc.perform(get("/doSomething").param("firstParam", "1").param("secondParam", "2"))
				.andExpect(status().isOk());
	}

	@Test
	public void slashへのPOST_許可されていないメソッド() throws Exception {
		mockMvc.perform(post("/doSomething")).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void paramCheck_NG() throws Exception {
		mockMvc.perform(get("/doSomething")).andExpect(status().isForbidden());
	}

}
