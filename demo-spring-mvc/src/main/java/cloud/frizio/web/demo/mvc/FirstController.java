package cloud.frizio.web.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

  @RequestMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }

  @RequestMapping("/processForm")
  public String processForm() {
    return "helloworld";
  }
  
}