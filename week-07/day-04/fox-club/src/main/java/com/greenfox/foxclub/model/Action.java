package com.greenfox.foxclub.model;

import java.time.LocalDateTime;

public class Action {

  private String text;
  private LocalDateTime date;

  private Action() {
    date = LocalDateTime.now();
  }

  public Action(Trick trick) {
    this();
    text = "Learned to: " + trick.name();
  }

  public Action(Food prevFood, Food nextFood) {
    this();
    text = "Food has been changed from: " + prevFood + " to: " + nextFood;
  }

  public Action(Drink prevDrink, Drink nextDrink) {
    this();
    text = "Drink has been changed from: " + prevDrink + " to: " + nextDrink;
  }

  @Override
  public String toString() {
    return date + " : " + text;
  }
}
