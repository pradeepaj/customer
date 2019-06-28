package com.hcl.bank.service;

import java.util.Map;

import com.hcl.bank.bean.CustomerBean;

public interface CustomerService {

	Object addCustomer(CustomerBean customerBean);

	Object getCustomer(long id);

	Object updateCustomer(CustomerBean customerBean);

	Object deleteCustomer(long id);

}
