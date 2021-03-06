package com.greenfoxacademy.webshop.controller;

import com.greenfoxacademy.webshop.components.SearchCriteria;
import com.greenfoxacademy.webshop.components.ShopItem;
import com.greenfoxacademy.webshop.containers.ShoppingList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webshop")
public class WebShopController {

  private ShoppingList shoppingList = new ShoppingList();

  @RequestMapping("")
  public String getWebShop(Model model, SearchCriteria sc) {
    model.addAttribute("shoppingList", shoppingList.getFiltered(sc));
    return "webshop";
  }

  @RequestMapping("/cheapest-first")
  public String getCheapestFirst(Model model) {
    model.addAttribute("shoppingList", shoppingList.getCheapestFirst());
    return "webshop";
  }

  @RequestMapping("/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute("result", shoppingList.getAverageStockAsString());
    return "results";
  }

  @RequestMapping("/most-expensive")
  public String getMostExpensive(Model model) {
    model.addAttribute("result", shoppingList.getMostExpensiveItemName());
    return "results";
  }

  @GetMapping("/add")
  public String getAddView(Model model) {
    model.addAttribute("shopItem", new ShopItem());
    return "shopItem";
  }

  @PostMapping("/add")
  public String addShopItem(@ModelAttribute ShopItem shopItem) {
    shoppingList.add(shopItem);
    return "redirect:/webshop";
  }

  @PostMapping("/delete/{id}")
  public String deleteShopItem(@PathVariable("id") String id) {
    shoppingList.delete(id);
    return "redirect:/webshop";
  }

}
