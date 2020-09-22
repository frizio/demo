package cloud.frizio.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  
  @GetMapping("/customLogin")
  public String customLogin() {
    return "custom-login";
  }

  @GetMapping("/fancyLogin")
  public String fancyLogin() {
    return "fancy-login";
  }

}
