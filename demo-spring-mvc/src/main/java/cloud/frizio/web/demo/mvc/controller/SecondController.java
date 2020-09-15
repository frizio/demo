package cloud.frizio.web.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {

  @RequestMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }
  
}
