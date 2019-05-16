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
        new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5)
    );
  }

  public List<ShopItem> get() {
    return shoppingList;
  }

  public void add(ShopItem shopItem) {
    shoppingList.add(shopItem);
  }

}
