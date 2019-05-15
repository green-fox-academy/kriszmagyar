package com.greenfoxacademy.springstart.controller;

import com.greenfoxacademy.springstart.components.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingWebController {

  private Counter c = new Counter();

  @RequestMapping("/web/greeting")
  public String greeting(Model model, @RequestParam String name) {
    c.inc();
    model.addAttribute("name", name);
    model.addAttribute("count", c.get());
    return "greeting";
  }

}
