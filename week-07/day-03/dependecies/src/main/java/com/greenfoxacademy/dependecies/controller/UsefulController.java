package com.greenfoxacademy.dependecies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsefulController {

  @GetMapping("/useful")
  public String index() {
    return "index";
  }

}
