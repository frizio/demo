package cloud.frizio.web.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/costumer")
public class CostumerController {
  
  @RequestMapping("/list")
  public String listCostumers(Model theModel) {

    return "list-costumers";
  }

}
