package cloud.frizio.web.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.frizio.web.demo.mvc.dao.CustomerDAO;
import cloud.frizio.web.demo.mvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerDAO customerDAO;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    // TODO Auto-generated method stub
    return customerDAO.getCustomers();
  }
  
}
