package com.greenfox.foxclub.model.store;

public enum Food {

  HAMBURGER("Hamburger"),
  PIZZA("Pizza"),
  GYROS("Gyros"),
  CHICKEN_WITH_RICE("Chicken with rice"),
  SALAD("Salad");

  public final String name;

  Food(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
