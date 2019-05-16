package com.greenfoxacademy.webshop.controller;

import com.greenfoxacademy.webshop.containers.ShoppingList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebShopController {

  private ShoppingList shoppingList = new ShoppingList();

  @RequestMapping ("/webshop")
  public String getWebShop(Model model) {
    model.addAttribute("shoppingList", shoppingList.get());
    return "webshop";
  }

  @RequestMapping("/webshop/only-available")
  public String getOnlyAvailable(Model model) {
    model.addAttribute("shoppingList", shoppingList.getAvailable());
    return "webshop";
  }

  @RequestMapping("/webshop/cheapest-first")
  public String getCheapestFirst(Model model) {
    model.addAttribute("shoppingList", shoppingList.getCheapestFirst());
    return "webshop";
  }

}
