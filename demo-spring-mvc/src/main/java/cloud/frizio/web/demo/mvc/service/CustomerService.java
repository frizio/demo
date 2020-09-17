package cloud.frizio.web.demo.mvc.service;

import java.util.List;

import cloud.frizio.web.demo.mvc.entity.Customer;

/**
 * CustomerService
 */
public interface CustomerService {

  public List<Customer> getCustomers();

}