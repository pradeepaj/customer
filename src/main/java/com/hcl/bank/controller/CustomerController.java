package com.hcl.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.bean.CustomerBean;
import com.hcl.bank.service.CustomerService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(allowedHeaders = "/*", origins = "/*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomer(@RequestBody CustomerBean customerBean) {
		Object custBean = customerService.addCustomer(customerBean);
		return new ResponseEntity<>(custBean, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
		Object custBean = customerService.getCustomer(id);
		return new ResponseEntity<>(custBean, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerBean customerBean) {
		Object custBean = customerService.updateCustomer(customerBean);
		return new ResponseEntity<>(custBean, HttpStatus.CREATED);
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
		Object mybean=customerService.deleteCustomer(id);
	return new ResponseEntity<>(mybean,HttpStatus.OK);
	
}
}
