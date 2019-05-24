package com.greenfox.foxclub.model.store;

public enum Drink {

  COLA ("Coca-Cola"),
  WATER ("Water"),
  COFFEE("Coffee"),
  BEER ("Beer"),
  VINE ("Vine");

  public final String name;

  Drink(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
