package com.example.springbhootcrudapp.app.servicei;

import java.util.List;
import java.util.Optional;

import com.example.springbhootcrudapp.app.model.Customer;

public interface CustomerServicei
{

	Customer saveCustomer(Customer c);

	List<Customer> getCustomers();

	Optional<Customer> getCustomerById(int customerId);

	Customer updateCustomer(int customerId, Customer c);

	void deleteCutomer(int customerId);

	Customer getBycustomerName(String customerName);

}
