package com.hcl.bank.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
		CustomerBean bean = customerServiceImpl.addCustomer(custBean);
		assertEquals(custBean, bean);

	}

	@Test
	public void getCustomerTest() {
		List<CustomerBean> li = new ArrayList<>();
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		li.add(custBean);
		when(customerRepository.getCustomer()).thenReturn(li);
		List<CustomerBean> cusb = customerServiceImpl.getCustomer(1);
		assertEquals(li, cusb);
	}

	@Test
	public void updateCustomerTest() {
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		CustomerBean custBean1 = new CustomerBean(1, "aj", 2345678, "kolkata");
		when(customerRepository.updateCustomer(Mockito.anyObject())).thenReturn(custBean1);
		CustomerBean cus = customerServiceImpl.updateCustomer(custBean1);
		System.out.println(custBean);
		System.out.println(cus);

		assertEquals(custBean1, cus);

	}

	@Test
	public void deleteCustomerTest() {
		CustomerBean custBean = new CustomerBean(1, "pradeep", 2345, "bglr");
		when(customerRepository.deleteCustomer(Mockito.anyLong())).thenReturn(custBean);
		CustomerBean cust = customerServiceImpl.deleteCustomer(1);
		assertEquals(custBean, cust);

	}

}
