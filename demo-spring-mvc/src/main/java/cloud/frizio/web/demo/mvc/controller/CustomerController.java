package cloud.frizio.web.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cloud.frizio.web.demo.mvc.dao.CustomerDAO;
import cloud.frizio.web.demo.mvc.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerDAO customerDao;
  
  @GetMapping("/list")
  public String listCustomers(Model theModel) {
    // Get customers from the dao
    List<Customer> theCustomers = customerDao.getCustomers();
    // Add customers to the model
    theModel.addAttribute("customers", theCustomers);
    return "list-customers";
  }

}
