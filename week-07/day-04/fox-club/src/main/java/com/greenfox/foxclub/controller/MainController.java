package com.greenfox.foxclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @GetMapping
  public String index() {
    return "index";
  }

  @GetMapping("/login")
  public String loginView() {
    return "login";
  }

  @PostMapping("/login")
  public String login() {
    return "redirect:/";
  }

}
