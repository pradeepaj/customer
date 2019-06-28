package com.hcl.bank.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.bean.CustomerBean;
import com.hcl.bank.model.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	@Mock
	private CustomerRepository customerRepository;

	@Test
	public void addCustomerTest() {
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		when(customerRepository.addCustomer(custBean)).thenReturn(custBean);
		Object bean = customerServiceImpl.addCustomer(custBean);
		assertEquals(custBean, bean);

	}

	@Test
	public void getCustomerTest() {
		Map<Long, CustomerBean> beanMap = new HashMap<>();
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		beanMap.put(custBean.getId(),custBean);
		when(customerRepository.getCustomer()).thenReturn(beanMap);
		Object cusb = customerServiceImpl.getCustomer(1L);
		assertEquals(custBean, cusb);
	}

	@Test
	public void updateCustomerTest() {
		Map<Long, CustomerBean> beanMap = new HashMap<>();
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		CustomerBean custBean1 = new CustomerBean(1, "aj", 2345678, "kolkata");
		beanMap.put(custBean.getId(), custBean);
		when(customerRepository.updateCustomer(Mockito.anyObject())).thenReturn(custBean1);
		Object cus = customerServiceImpl.updateCustomer(custBean1);
		assertEquals(custBean1, cus);


	}

	@Test
	public void deleteCustomerTest() {
		
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		
		when(customerRepository.deleteCustomer(Mockito.anyLong())).thenReturn(custBean);
		Object cust = customerServiceImpl.deleteCustomer(1);
		assertEquals(custBean, cust);

	}

}
