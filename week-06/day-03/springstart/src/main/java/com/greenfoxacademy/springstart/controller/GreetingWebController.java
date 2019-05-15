package com.greenfoxacademy.springstart.controller;

import com.greenfoxacademy.springstart.components.Counter;
import com.greenfoxacademy.springstart.components.Hello;
import com.greenfoxacademy.springstart.components.HelloFactory;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingWebController {

  private Counter c = new Counter();
  private HelloFactory helloFactory = new HelloFactory();

  @RequestMapping("/web/greeting")
  public String greeting(Model model, @RequestParam String name) {
    c.inc();
    model.addAttribute("name", name);
    model.addAttribute("count", c.get());
    return "greeting";
  }

  @RequestMapping("/web/greetings")
  public String greetings() {
    return "greetings";
  }

  @ModelAttribute("hellos")
  public List<Hello> hellos() {
    return helloFactory.generate();
  }

}
