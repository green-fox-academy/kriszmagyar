package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.store.Drink;
import com.greenfox.foxclub.model.store.Food;
import com.greenfox.foxclub.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  private FoxService fs;

  @GetMapping("/")
  public String index(@RequestParam(required = false) String name, Model model) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    model.addAttribute("actions", fs.getActions(name, 5));
    return "index";
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam(required = false) String name, Model model) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    model.addAttribute("store", fs.getByName(name).getStore());
    model.addAttribute("foodSet", Food.values());
    model.addAttribute("drinkSet", Drink.values());
    return "nutrition_store";
  }

  @GetMapping("/trickCenter")
  public String trickCenter(@RequestParam(required = false) String name, Model model) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    model.addAttribute("newTricks", fs.getNewTricks(name));
    return "trick_center";
  }

  @GetMapping("/actionHistory")
  public String actionHistory(@RequestParam(required = false) String name, Model model) {
    if (fs.isNotAuthorized(name)) {
      return "redirect:/login";
    }
    model.addAttribute("actions", fs.getActions(name));
    return "action_history";
  }

  @ModelAttribute
  public void setupFox(@RequestParam(required = false) String name, Model model) {
    model.addAttribute("fox", fs.getByName(name));
  }
}
