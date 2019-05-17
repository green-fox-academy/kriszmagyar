package com.greenfoxacademy.webshop.controller;

import com.greenfoxacademy.webshop.components.ShopItem;
import com.greenfoxacademy.webshop.containers.ShoppingList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {

  private ShoppingList shoppingList = new ShoppingList();

  @RequestMapping ("/webshop")
  public String getWebShop(Model model,
      @RequestParam(value = "search", defaultValue = "") String search) {
    model.addAttribute("shoppingList", shoppingList.getWithContains(search));
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

  @RequestMapping("/webshop/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute("result", shoppingList.getAverageStockAsString());
    return "results";
  }

  @RequestMapping("/webshop/most-expensive")
  public String getMostExpensive(Model model) {
    model.addAttribute("result", shoppingList.getMostExpensiveItemName());
    return "results";
  }

  @GetMapping("/webshop/add")
  public String getAddView(Model model) {
    model.addAttribute("shopItem", new ShopItem());
    return "add";
  }

  @PostMapping(value = "/webshop/add")
  public String addShopItem(
      @RequestParam("name") String name,
      @RequestParam("description") String description,
      @RequestParam("price") double price,
      @RequestParam("stock") int stock
  ) {
    shoppingList.add(new ShopItem(name, description, price, stock));
    return "redirect:/webshop";
  }

}
