package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.store.Drink;
import com.greenfox.foxclub.model.store.Food;
import com.greenfox.foxclub.model.Trick;
import com.greenfox.foxclub.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fox")
public class FoxController {

  @Autowired
  private FoxService fs;

  @PostMapping("/changeNutrition")
  public String changeNutrition(@RequestParam String name, Food food, Drink drink) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    fs.changeNutrition(name, food, drink);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/learnTrick")
  public String learnTrick(@RequestParam String name, Trick trick) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    fs.learnTrick(name, trick);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/performTrick")
  public String performTrick(@RequestParam String name, Trick trick) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    fs.performTrick(name, trick);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/fillUpFood")
  public String fillUpFood(@RequestParam String name) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    fs.fillUpFood(name);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/fillUpDrink")
  public String fillUpDrink(@RequestParam String name) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    fs.fillUpDrink(name);
    return "redirect:/?name=" + name;
  }

}
