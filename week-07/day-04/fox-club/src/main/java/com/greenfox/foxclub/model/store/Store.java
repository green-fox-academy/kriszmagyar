package com.greenfox.foxclub.model.store;

import static com.greenfox.foxclub.model.store.Drink.COLA;
import static com.greenfox.foxclub.model.store.Food.HAMBURGER;

import com.greenfox.foxclub.model.fox.Action;
import java.util.List;
import java.util.Random;

public class Store {

  private Food food;
  private Food favoriteFood;
  private int maxFood;
  private int currentFood;

  private Drink drink;
  private Drink favoriteDrink;
  private int maxDrink;
  private int currentDrink;

  private List<Action> actions;
  private Random random = new Random();

  public Store(List<Action> actions) {
    food = HAMBURGER;
    maxFood = 10;
    currentFood = maxFood;
    favoriteFood = getRandomFood();
    drink = COLA;
    maxDrink = 8;
    currentDrink = maxDrink;
    favoriteDrink = getRandomDrink();
    this.actions = actions;
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

  private Food getRandomFood() {
    Food[] foods = Food.values();
    return foods[random.nextInt(foods.length)];
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

  public Food getFavoriteFood() {
    return favoriteFood;
  }

  public void doEat() {
    currentFood = Math.max(currentFood - 1, 0);
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

  private Drink getRandomDrink() {
    Drink[] drinks = Drink.values();
    return drinks[random.nextInt(drinks.length)];
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

  public Drink getFavoriteDrink() {
    return favoriteDrink;
  }

  public void doDrink() {
    currentDrink = Math.max(currentDrink - 1, 0);
  }

  public void changeFavorits() {
    favoriteFood = getRandomFood();
    favoriteDrink = getRandomDrink();
  }

}