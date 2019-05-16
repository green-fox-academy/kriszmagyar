package com.greenfoxacademy.webshop.controller;

import com.greenfoxacademy.webshop.components.ShopItem;
import com.greenfoxacademy.webshop.containers.ShoppingList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebShopController {

  private ShoppingList shoppingList = new ShoppingList();

  @RequestMapping ("/webshop")
  public String getWebShop() {
    return "webshop";
  }

  @ModelAttribute ("shoppingList")
  public List<ShopItem> shoppingList() {
    return shoppingList.get();
  }

}
