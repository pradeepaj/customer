package com.hcl.bank.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hcl.bank.bean.CustomerBean;

@Repository
public class CustomerRepository {

	static List<CustomerBean> customerData = new ArrayList<>();
	
	static {
		CustomerBean customerBean1 =  new CustomerBean(1001L, "Laxman verma", 90456788, "Blore");
		CustomerBean customerBean2 =  new CustomerBean(1002L, "Pradepa AJ", 903456, "Blore");
		CustomerBean customerBean3 =  new CustomerBean(1003L, "Ankite Panda", 804658, "Bhopal");
		customerData.add(customerBean1);
		customerData.add(customerBean2);
		customerData.add(customerBean3);
	}

	public CustomerBean addCustomer(CustomerBean custBean) {
		if(customerData.add(custBean)) {
			return custBean;
		}
		return null;
	}

	public List<CustomerBean> getCustomer() {
		return customerData;
	}

	

	public CustomerBean updateCustomer(CustomerBean customerBean) {
		CustomerBean customerBean1=null;
		if(!customerData.isEmpty()) {
			for(CustomerBean custBean:customerData) {
				if(custBean.getId()==customerBean.getId()) {
					customerBean1=custBean;
					break;
				}
			}
		}
		customerData.remove(customerBean1);
		customerData.add(customerBean);
		return customerBean;
	}
	
	public CustomerBean deleteCustomer(long id) {
		CustomerBean customerBean2= getCustomerDetail(id);
		customerData.remove(customerBean2);
		return customerBean2;
	}
	
	private CustomerBean getCustomerDetail(long id) {
		CustomerBean customerBean=null;
		if(!customerData.isEmpty()) {
			for(CustomerBean custBean:customerData) {
				if(custBean.getId()==id) {
					customerBean=custBean;
					break;
				}
			}
		}
		return customerBean;
	}
}