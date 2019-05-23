package com.greenfox.foxclub.model;

import static com.greenfox.foxclub.model.Drink.COLA;
import static com.greenfox.foxclub.model.Food.HAMBURGER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fox {

  private String name;
  private Food food;
  private Drink drink;
  private Set<Trick> tricks;

  public Fox() {
    this("");
  }

  public Fox(String name) {
    this.name = name;
    food = HAMBURGER;
    drink = COLA;
    tricks = new HashSet<>();
  }

  public void learTrick(Trick trick) {
    tricks.add(trick);
  }

  public boolean isNewTrick(Trick trick) {
    return !tricks.contains(trick);
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

  public Set<Trick> getTricks() {
    return tricks;
  }
}
