package com.greenfox.foxclub.model;

import static com.greenfox.foxclub.model.Drink.COLA;
import static com.greenfox.foxclub.model.Food.HAMBURGER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Fox {

  private String name;
  private Food food;
  private int maxFood;
  private int currentFood;
  private Drink drink;
  private int maxDrink;
  private int currentDrink;
  private Set<Trick> tricks;
  private List<Action> actions;

  public Fox() {
    this("");
  }

  public Fox(String name) {
    this.name = name;
    food = HAMBURGER;
    maxFood = 10;
    currentFood = maxFood;
    drink = COLA;
    maxDrink = 8;
    currentDrink = maxDrink;
    tricks = new HashSet<>();
    actions = new ArrayList<>();
    digest();
  }

  public void learTrick(Trick trick) {
    tricks.add(trick);
    actions.add(new Action(trick));
  }

  public void performTrick(Trick trick) {
    actions.add(new Action(trick, true));
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
    if (this.food == food) {
      return;
    }
    Food prevFood = this.food;
    this.food = food;
    actions.add(new Action(prevFood, food));
  }

  public int getMaxFood() {
    return maxFood;
  }

  public int getCurrentFood() {
    return currentFood;
  }

  public void fillUpFood() {
    actions.add(new Action(food, currentFood, maxFood));
    currentFood = maxFood;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    if (this.drink == drink) {
      return;
    }
    Drink prevDrink = this.drink;
    this.drink = drink;
    actions.add(new Action(prevDrink, drink));
  }

  public int getMaxDrink() {
    return maxDrink;
  }

  public int getCurrentDrink() {
    return currentDrink;
  }

  public void fillUpDrink() {
    actions.add(new Action(drink, currentDrink, maxDrink));
    currentDrink = maxDrink;
  }

  public Set<Trick> getTricks() {
    return tricks;
  }

  public List<Action> getActions() {
    return actions;
  }

  private void digest() {
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        currentFood = Math.max(currentFood - 1, 0);
        currentDrink = Math.max(currentDrink - 1, 0);
      }
    }, 5 * 1000, 5 * 1000);
  }

  @Override
  public String toString() {
    return String.format("This is %s. Currently living on %s and %s. Knows %s tricks.",
        name, food, drink, tricks.size()
    );
  }
}
