package cloud.frizio.web.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cloud.frizio.web.demo.mvc.entity.Customer;
import cloud.frizio.web.demo.mvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;
  
  @GetMapping("/list")
  public String listCustomers(Model theModel) {
    // Get customers from the dao
    List<Customer> theCustomers = customerService.getCustomers();
    // Add customers to the model
    theModel.addAttribute("customers", theCustomers);
    return "list-customers";
  }

}
