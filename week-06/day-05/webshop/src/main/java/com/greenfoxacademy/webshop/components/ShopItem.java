package com.greenfoxacademy.webshop.components;

public class ShopItem {

  private String name;
  private String description;
  private double price;
  private int quantity;

  public ShopItem(String name, String description, double price, int quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public boolean isAvaiable() {
    return quantity > 0;
  }

  public boolean isContains(String search) {
    return false;
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

  public int getQuantity() {
    return quantity;
  }
}
