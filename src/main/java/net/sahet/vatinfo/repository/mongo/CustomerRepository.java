package net.sahet.vatinfo.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.sahet.vatinfo.domain.mongo.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
