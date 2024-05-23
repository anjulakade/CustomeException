package com.example.springbhootcrudapp.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbhootcrudapp.app.model.Customer;

import com.example.springbhootcrudapp.app.servicei.CustomerServicei;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	CustomerServicei csi;
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer c)
	{
		
		return csi.saveCustomer(c);
	}
	@GetMapping("/customers")
  public List<Customer> getCustomers()
  {
		List<Customer> clist=csi.getCustomers();
		 return clist;
  }
	@GetMapping("/customer/{customerId}")
	public  Optional<Customer> getCustomerById(@PathVariable int customerId)
	{
		Optional<Customer> customer=csi.getCustomerById(customerId);
		  return customer;
   }
	 @PutMapping("/customerId/{customerId}")
	  public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer c) {
		 Customer customer=csi.updateCustomer(customerId,c);
		  return customer;
	}
	 @DeleteMapping("/customer/{customerId}")
	public void deleteCutomer(@PathVariable int customerId) 
	 { 
		 csi.deleteCutomer(customerId);
	  }
	 @GetMapping("/customername/{customerName}")
	 public ResponseEntity<Customer> getBycustomerName(@PathVariable String customerName)
	 {
		// int a=10/0;
		 Customer customer =csi.getBycustomerName(customerName);
		   return  new ResponseEntity<Customer>(customer,HttpStatus.OK);
	 }
}


