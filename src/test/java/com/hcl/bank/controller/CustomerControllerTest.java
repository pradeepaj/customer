package com.hcl.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bank.bean.CustomerBean;
import com.hcl.bank.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, CustomerController.class })
@WebAppConfiguration
public class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;
	@Mock
	private CustomerService customerService;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(CustomerController.class).build();
	}

	@Test
	public void getCustomerTest() throws JsonProcessingException, Exception {
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		when(customerService.getCustomer(1)).thenReturn(custBean);
		this.mockMvc.perform(
				get("/create/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(custBean)));
		ResponseEntity<CustomerBean> bean = customerController.getCustomer(1);
		System.out.println(bean);
		assertEquals(200, bean.getStatusCodeValue());

	}

	
	@Test(expected = NestedServletException.class)
	public void addCustomerTest() throws JsonProcessingException, Exception {

		CustomerBean customerBean = new CustomerBean(1L, "Laxman", 90888, "Blore");
		when(customerService.addCustomer(Mockito.anyObject())).thenReturn(customerBean);
		this.mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customerBean))).andReturn();
		ResponseEntity<CustomerBean> custResponseEntity = customerController.addCustomer(customerBean);
		assertEquals(201, custResponseEntity.getStatusCodeValue());
	}

	@Test
	public void updateCustomerTest() throws JsonProcessingException, Exception {

		CustomerBean customerBean1 = new CustomerBean(1L, "Aniketa", 903546, "HCL Blore");
		when(customerService.updateCustomer(Mockito.anyObject())).thenReturn(customerBean1);
		this.mockMvc.perform(put("/customer/update").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(Mockito.anyObject())));
		ResponseEntity<CustomerBean> custResponseEntity = customerController.updateCustomer(customerBean1);
		System.out.println(custResponseEntity);
		assertEquals(201, custResponseEntity.getStatusCodeValue());
	}

	@Test
	public void deleteCustomerTest() throws JsonProcessingException, Exception {
		CustomerBean customerBean1 = new CustomerBean(1L, "Aniketa", 903546, "HCL Blore");
		doNothing().when(customerService).deleteCustomer(Mockito.anyLong());
		this.mockMvc.perform(delete("/customer/delete").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customerBean1)));
		customerController.deleteCustomer(1L);
	}

	public static String asJsonString(final Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}
}
