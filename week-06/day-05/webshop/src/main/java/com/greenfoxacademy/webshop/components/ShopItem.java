package com.greenfoxacademy.webshop.components;

public class ShopItem {

  private String name;
  private String description;
  private double price;
  private int stock;

  public ShopItem(String name, String description, double price, int stock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  public boolean isAvaiable() {
    return stock > 0;
  }

  public boolean isContains(String search) {
    return name.toLowerCase().contains(search.toLowerCase())
        || description.toLowerCase().contains(search.toLowerCase());
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getStock() {
    return stock;
  }
}
