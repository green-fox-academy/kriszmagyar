package com.greenfoxacademy.dependecies.controller;

import com.greenfoxacademy.dependecies.service.utility.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/useful")
public class UsefulController {

  @Autowired
  private UtilityService utilityService;

  @GetMapping
  public String index() {
    return "index";
  }

  @GetMapping("/colored")
  public String getColoredPage(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @GetMapping("/email")
  public String validateEmail(Model model, String email) {
    model.addAttribute("email", utilityService.validateEmail(email));
    return "email";
  }

  @ResponseBody
  @GetMapping("/encode")
  public String encode(String text, int number) {
    return utilityService.encode(text, number);
  }

  @ResponseBody
  @GetMapping("/decode")
  public String decode(String text, int number) {
    return utilityService.decode(text, number);
  }

}
