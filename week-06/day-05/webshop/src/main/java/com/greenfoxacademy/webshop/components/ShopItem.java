package com.greenfoxacademy.webshop.components;

public class ShopItem {

  private String id;
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

  public ShopItem() {
    id = "";
    name = "";
    description = "";
    price = 0.0;
    stock = 0;
  }

  public boolean isAvailable() {
    return stock > 0;
  }

  public boolean isContains(String search) {
    return name.toLowerCase().contains(search.toLowerCase())
        || description.toLowerCase().contains(search.toLowerCase());
  }

  public String getId() {
    return id;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "ShopItem{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        '}';
  }
}
