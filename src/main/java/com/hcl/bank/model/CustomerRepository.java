package com.hcl.bank.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hcl.bank.bean.CustomerBean;

@Repository
public class CustomerRepository {

	static Map<Long, CustomerBean> customerMap = new HashMap<>();

	static {

		CustomerBean customerBean1 = new CustomerBean(1001L, "Laxman verma", 90456788, "Blore");
		CustomerBean customerBean2 = new CustomerBean(1002L, "Pradepa AJ", 903456, "Blore");
		CustomerBean customerBean3 = new CustomerBean(1003L, "Ankite Panda", 804658, "Bhopal");
		customerMap.put(customerBean1.getId(), customerBean1);
		customerMap.put(customerBean2.getId(), customerBean2);
		customerMap.put(customerBean3.getId(), customerBean3);
	}

	public Object addCustomer(CustomerBean custBean) {
		if (custBean != null) {
			customerMap.put(custBean.getId(), custBean);
		}
		return customerMap.get(custBean.getId());
	}

	public Map<Long, CustomerBean> getCustomer() {
		return customerMap;
	}

	public Object updateCustomer(CustomerBean customerBean) {

		if (customerMap.containsKey(customerBean.getId())) {
			customerMap.put(customerBean.getId(), customerBean);
		}
		return customerMap.get(customerBean.getId());
	}

	public Object deleteCustomer(long id) {
		customerMap.remove(id);
		return customerMap;
	}

//private CustomerBean getCustomerDetail(long id) {
//		CustomerBean customerBean=null;
//		if(!customerData.isEmpty()) {
//		for(CustomerBean custBean:customerData) {
//				if(custBean.getId()==id) {
//					customerBean=custBean;
//				break;
//				}
//		}
//		}
//	return customerBean;
//	}
}