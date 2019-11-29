package net.sahet.vatinfo.repository;

import java.util.List;

import net.sahet.vatinfo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

  public Customer findByFirstName(String firstName);
  public List<Customer> findByLastName(String lastName);

}
