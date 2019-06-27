package com.hcl.bank.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
	private CustomerServiceImpl  customerServiceImpl;
	@Mock
	private CustomerRepository customerRepository; 
	

	@Test
	public void addCustomerTest() {
		CustomerBean custBean=new CustomerBean(1, "pradeep", 2345, "bglr");
		when(customerRepository.addCustomer(custBean)).thenReturn(custBean);
		CustomerBean bean=customerServiceImpl.addCustomer(custBean);
		assertEquals(custBean, bean);
		
	}
	@Test
	public void getCustomerTest() {
		CustomerBean custBean=new CustomerBean(1, "pradeep", 2345, "bglr");
		when(customerRepository.getCustomer(1)).thenReturn(custBean);
		CustomerBean cusb=customerServiceImpl.getCustomer(1);
		assertEquals(custBean, cusb);
	}
	@Test
	public void updateCustomerTest() {
		CustomerBean custBean=new CustomerBean(1, "pradeep", 2345, "bglr");
		CustomerBean custBean1=new CustomerBean(1, "aj", 2345678, "kolkata");
		when(customerRepository.updateCustomer(Mockito.anyObject())).thenReturn(custBean1);
		CustomerBean cus=customerServiceImpl.updateCustomer(custBean1);
		System.out.println(custBean);
		System.out.println(cus);
		
		assertEquals(custBean1, cus);
		
		
	}
	
	@Test
	public void deleteCustomerTest() {
		String msg =null;
		CustomerBean custBean=new CustomerBean(1, "pradeep", 2345, "bglr");
		doNothing().when(customerRepository).deleteCustomer(Mockito.anyLong());
		customerServiceImpl.deleteCustomer(1);
		

	
	
	}
	

}
