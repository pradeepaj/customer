package com.hcl.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void getCustomerTest() throws JsonProcessingException, Exception {
		List<CustomerBean> custBeanList = new ArrayList<>();
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		custBeanList.add(custBean);
		ResponseEntity<List<CustomerBean>> res=new ResponseEntity<>(custBeanList, HttpStatus.OK);
		Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(custBeanList);
		this.mockMvc
				.perform(get("/bank/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(custBeanList)))
				.andReturn();
		ResponseEntity<List<CustomerBean>> res1=	customerController.getCustomer(1);
		assertEquals(res,res1);

	}

	@Test
	public void addCustomerTest() throws JsonProcessingException, Exception {

		CustomerBean customerBean = new CustomerBean(1L, "Laxman", 90888, "Blore");
		when(customerService.addCustomer(Mockito.anyObject())).thenReturn(customerBean);
		this.mockMvc.perform(
				post("/bank/customer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customerBean)))
				.andReturn();
		ResponseEntity<CustomerBean> custResponseEntity = customerController.addCustomer(customerBean);
		assertEquals(201, custResponseEntity.getStatusCodeValue());
	}

	@Test
	public void updateCustomerTest() throws JsonProcessingException, Exception {

		CustomerBean customerBean1 = new CustomerBean(1L, "Aniketa", 903546, "HCL Blore");
		when(customerService.updateCustomer(Mockito.anyObject())).thenReturn(customerBean1);
		this.mockMvc.perform(put("/bank/{id}", 1L).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(Mockito.anyObject())));
		ResponseEntity<CustomerBean> custResponseEntity = customerController.updateCustomer(customerBean1);
		System.out.println(custResponseEntity);
		assertEquals(201, custResponseEntity.getStatusCodeValue());
	}

	@Test
	public void deleteCustomerTest() throws JsonProcessingException, Exception {
		CustomerBean customerBean1 = new CustomerBean(1L, "Aniketa", 903546, "HCL Blore");
		ResponseEntity<CustomerBean> res1 = new ResponseEntity<>(customerBean1, HttpStatus.OK);
		when(customerService.deleteCustomer(Mockito.anyLong())).thenReturn(customerBean1);
		this.mockMvc.perform(delete("/bank/customer/{id}", 1L).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customerBean1))).andReturn();
		ResponseEntity<CustomerBean> res = customerController.deleteCustomer(1L);
		assertEquals(res1, res);

	}

	public static String asJsonString(final Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}
}
