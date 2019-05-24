package com.greenfox.foxclub.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

  public Action(Trick trick, boolean isPerforming) {
    this();
    if (isPerforming) {
      text = "Performing: " + trick.name();
    }
  }

  public Action(Food prevFood, Food nextFood) {
    this();
    text = "Food has been changed from: " + prevFood + " to: " + nextFood;
  }

  public Action(Food food, int from, int to) {
    this();
    text = "Filling up " + food + " from " + from + " to " + to;
  }

  public Action(Drink prevDrink, Drink nextDrink) {
    this();
    text = "Drink has been changed from: " + prevDrink + " to: " + nextDrink;
  }

  public Action(Drink drink, int from, int to) {
    this();
    text = "Filling up " + drink + " from " + from + " to " + to;
  }

  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public String toString() {
    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        + " - " + text;
  }
}
