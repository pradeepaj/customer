package com.hcl.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public CustomerBean addCustomer(CustomerBean customerBean) {
		return custRepo.addCustomer(customerBean);
	}

	@Override
	public List<CustomerBean> getCustomer(long id) {
		
		List<CustomerBean> custBeanList = custRepo.getCustomer();
		List<CustomerBean> custBeanData = new ArrayList<>();
		
		for(CustomerBean custBean : custBeanList) {
			if(custBean.getId()==id) {
				custBeanData.add(custBean);
				break;
			}
		}
		if(custBeanData.isEmpty()) {
			return custBeanList;
		} else {
			return custBeanData;
		}
	}

	@Override
	public CustomerBean updateCustomer(CustomerBean customerBean) {
		return custRepo.updateCustomer(customerBean);
	}

	@Override
	public CustomerBean deleteCustomer(long id) {
		return custRepo.deleteCustomer(id);
	}

}
