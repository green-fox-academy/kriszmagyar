package com.greenfoxacademy.springstart.controller;

import com.greenfoxacademy.springstart.components.Counter;
import com.greenfoxacademy.springstart.components.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private Counter c = new Counter();

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam String name) {
      c.inc();
      return new Greeting(c.get(), "Hello, " + name + "!");
  }

}
