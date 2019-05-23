package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  private FoxService fs;

  @GetMapping
  public String index(@RequestParam(required = false) String name, Model model) {
    if (name == null || name.isEmpty() || !fs.exists(name)) {
      return "redirect:/login";
    }

    model.addAttribute("name", name);
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
