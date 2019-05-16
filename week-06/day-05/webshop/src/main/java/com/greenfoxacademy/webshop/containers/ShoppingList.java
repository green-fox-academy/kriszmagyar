package com.greenfoxacademy.webshop.containers;

import com.greenfoxacademy.webshop.components.ShopItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {

  private List<ShopItem> shoppingList;

  public ShoppingList() {
    populate();
  }

  private void populate() {
    shoppingList = Arrays.asList(
        new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5),
        new ShopItem("Printer", "Some HP printer that prints pages", 3000, 2),
        new ShopItem("Coca cola", "0.5l standard coke", 25, 0),
        new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100),
        new ShopItem("T-shirt", "Blue with a corgi on a bike", 1000, 5)
    );
  }

  public List<ShopItem> get() {
    return shoppingList;
  }

  public void add(ShopItem shopItem) {
    shoppingList.add(shopItem);
  }

}
