package com.hcl.bank.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.bean.CustomerBean;
import com.hcl.bank.model.CustomerRepository;
import com.hcl.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Object addCustomer(CustomerBean customerBean) {
		return custRepo.addCustomer(customerBean);
	}

	@Override
	public Object getCustomer(long id) {

		Map<Long, CustomerBean> custBeanMap = custRepo.getCustomer();

		if (custBeanMap.containsKey(id)) {
			return custBeanMap.get(id);
		} else {
			return custBeanMap;
		}

	}

	@Override
	public Object updateCustomer(CustomerBean customerBean) {
		return custRepo.updateCustomer(customerBean);
	}

	@Override
	public Object deleteCustomer(long id) {
		return custRepo.deleteCustomer(id);
	}

}
