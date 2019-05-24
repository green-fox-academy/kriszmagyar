package com.greenfox.foxclub.model;

public enum Food {

  HAMBURGER ("Hamburger"),
  PIZZA ("Pizza"),
  GYROS ("Gyros");

  public final String name;

  Food(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
