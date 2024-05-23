package com.example.springbhootcrudapp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbhootcrudapp.app.exception.CustomerNotFoundException;
import com.example.springbhootcrudapp.app.model.Customer;
import com.example.springbhootcrudapp.app.repository.CustomerRepository;
import com.example.springbhootcrudapp.app.servicei.CustomerServicei;

@Service
public class CustomerServiceImpl implements CustomerServicei
{
	@Autowired
	CustomerRepository cr;

	@Override
	public Customer saveCustomer(Customer c) {
		
		return cr.save(c);
	}

	@Override
	public List<Customer> getCustomers() {
				return cr.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		Optional<Customer> customer=cr.findById(customerId);
		  return customer;
		}

	@Override
	public Customer updateCustomer(int customerId, Customer c) 
	{
		
		return cr.save(c);
	}

	@Override
	public void deleteCutomer(int customerId)
	{
		cr.deleteById(customerId);
	}

	@Override
	public Customer getBycustomerName(String customerName) 
	{		 
		Customer c=cr.getBycustomerName(customerName);
		 
		 if (c!=null)
		 {
			 return c;
		 }
		 else {
			 throw new CustomerNotFoundException(" Customer not found");
		 }
		
	}
}
