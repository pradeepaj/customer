package com.hcl.bank.service;

import java.util.List;

import com.hcl.bank.bean.CustomerBean;

public interface CustomerService {

	CustomerBean addCustomer(CustomerBean customerBean);

	List<CustomerBean> getCustomer(long id);

	CustomerBean updateCustomer(CustomerBean customerBean);

	CustomerBean deleteCustomer(long id);

}
