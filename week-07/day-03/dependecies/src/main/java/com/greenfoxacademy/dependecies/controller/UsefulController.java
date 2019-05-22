package com.greenfoxacademy.dependecies.controller;

import com.greenfoxacademy.dependecies.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    model.addAttribute("email", email);
    return "email";
  }

}
