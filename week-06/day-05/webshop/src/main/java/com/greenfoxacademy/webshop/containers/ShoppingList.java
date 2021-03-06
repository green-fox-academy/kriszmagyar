package com.greenfoxacademy.webshop.containers;

import com.greenfoxacademy.webshop.components.SearchCriteria;
import com.greenfoxacademy.webshop.components.ShopItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingList {

  private List<ShopItem> shoppingList;

  public ShoppingList() {
    populate();
  }

  private void populate() {
    shoppingList = new ArrayList<>();
    add(new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5));
    add(new ShopItem("Printer", "Some HP printer that prints pages", 3000, 2));
    add(new ShopItem("Coca cola", "0.5l standard coke", 25, 0));
    add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100));
    add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 1000, 5));
  }

  public List<ShopItem> get() {
    return shoppingList;
  }

  public List<ShopItem> getFiltered(SearchCriteria sc) {
    return shoppingList.stream()
        .filter(item -> item.isContains(sc.getSearch()))
        .filter(item -> !sc.isAvailable() || item.isAvailable())
        .collect(Collectors.toList());
  }

  public List<ShopItem> getCheapestFirst() {
    return shoppingList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice))
        .collect(Collectors.toList());
  }

  public String getAverageStockAsString() {
    return "Average stock: " + getAverageStock();
  }

  double getAverageStock() {
    return shoppingList.stream()
        .mapToDouble(ShopItem::getStock)
        .average()
        .orElse(0);
  }

  public String getMostExpensiveItemName() {
    return shoppingList.stream()
        .max(Comparator.comparing(ShopItem::getPrice))
        .map(ShopItem::getName)
        .orElse("");
  }

  public void add(ShopItem shopItem) {
    shopItem.setId(shopItem.getId() == null ? generateId() : shopItem.getId());
    shoppingList.add(shopItem);
  }

  public void delete(String id) {
    shoppingList = shoppingList.stream()
        .filter(item -> !item.getId().equals(id))
        .collect(Collectors.toList());
  }

  private String generateId() {
    return "id" + Math.random() * 10000;
  }

  public void clear() {
    shoppingList.clear();
  }

}