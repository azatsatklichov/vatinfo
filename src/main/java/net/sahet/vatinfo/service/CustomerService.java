package net.sahet.vatinfo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.sahet.vatinfo.domain.Customer;
import net.sahet.vatinfo.repository.CustomerRepository;

@Service
//@Profile("prod")
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void deleteAllCustomers() {
		/**
		 * By default, the instance tries to connect to a MongoDB server at
		 * mongodb://localhost/test
		 * 
		 * OK
		 */
		customerRepository.deleteAll();

	}

	public List<Customer> getCustomers(String firstName, String lastName) {
		/**
		 * By default, the instance tries to connect to a MongoDB server at
		 * mongodb://localhost/test
		 * 
		 * OK
		 */
		customerRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer(firstName, lastName));
		// just make reversed Initials
		customerRepository.save(new Customer(lastName, firstName));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		List<Customer> findAll = customerRepository.findAll();
		for (Customer customer : findAll) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName():");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName(firstName));

		System.out.println("Customers found with findByLastName():");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName(lastName)) {
			System.out.println(customer);
		}

		return findAll;
	}

}
