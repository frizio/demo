package cloud.frizio.web.demo.mvc.dao;

import java.util.List;

import cloud.frizio.web.demo.mvc.entity.Customer;

public interface CustomerDAO {

  public List<Customer> getCustomers();
  
}
