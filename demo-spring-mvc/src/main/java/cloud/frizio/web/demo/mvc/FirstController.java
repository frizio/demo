package cloud.frizio.web.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @RequestMapping("/processFormV2")
  public String processFormAndConvert(HttpServletRequest request, Model model) {
    String theName = request.getParameter("studentName");
    String result = "Yo! " + theName.toUpperCase();
    model.addAttribute("message", result);
    return "helloworld";
  }
  
}