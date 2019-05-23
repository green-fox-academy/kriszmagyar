package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Drink;
import com.greenfox.foxclub.model.Food;
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
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    model.addAttribute("fox", fs.getByName(name));
    return "index";
  }

  @GetMapping("/login")
  public String loginView(Model model) {
    model.addAttribute("fox", new Fox());
    return "login";
  }

  @PostMapping("/login")
  public String login(Fox fox) {
    fs.add(fox);
    return "redirect:/?name=" + fox.getName();
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam String name, Model model) {
    model.addAttribute("fox", fs.getByName(name));
    model.addAttribute("foodSet", Food.values());
    model.addAttribute("drinkSet", Drink.values());
    return "nutrition_store";
  }

}
