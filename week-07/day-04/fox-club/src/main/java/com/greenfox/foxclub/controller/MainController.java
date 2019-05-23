package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @GetMapping
  public String index() {
    return "index";
  }

  @GetMapping("/login")
  public String loginView(Model model) {
    model.addAttribute("fox", new Fox());
    return "login";
  }

  @PostMapping("/login")
  public String login(Fox fox) {
    return "redirect:/?name=" + fox.getName();
  }

}
