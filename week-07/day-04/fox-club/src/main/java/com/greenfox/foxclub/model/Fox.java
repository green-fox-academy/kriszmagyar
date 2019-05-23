package com.greenfox.foxclub.model;

import static com.greenfox.foxclub.model.Drink.COLA;
import static com.greenfox.foxclub.model.Food.HAMBURGER;

public class Fox {

  private String name;
  private Food food;
  private Drink drink;

  public Fox() {
    this("");
  }

  public Fox(String name) {
    this.name = name;
    food = HAMBURGER;
    drink = COLA;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }
}
