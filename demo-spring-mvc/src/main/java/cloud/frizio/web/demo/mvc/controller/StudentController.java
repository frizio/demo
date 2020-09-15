package cloud.frizio.web.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cloud.frizio.web.demo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

  @RequestMapping("showForm")
  public String showForm(Model theModel) {
    Student theStudent = new Student();
    theModel.addAttribute("student", theStudent);
    return "student-form";
  }

  @RequestMapping("processForm")
  public String processForm(@ModelAttribute("student") Student theStudent) {
    return "student-confimation";
  }

}
