package net.sahet.vatinfo.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.vatinfo.domain.Customer;
import net.sahet.vatinfo.service.CustomerService;

@RestController
public class CustomerResource {

	private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);

	@Autowired
	CustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	public List<Customer> getCustomers(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, Map<String, Object> model) {

		List<Customer> list = customerService.getCustomers(firstName, lastName);

		return list;

	}

}
