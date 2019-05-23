package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Drink;
import com.greenfox.foxclub.model.Food;
import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import com.greenfox.foxclub.repository.FoxRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository fr;
  private List<Fox> foxes;

  public FoxService(FoxRepository fr) {
    this.fr = fr;
    foxes = fr.get();
  }

  public Fox getByName(String name) {
    return foxes.stream()
        .filter(f -> f.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  public void add (Fox fox) {
    foxes.add(fox);
    fr.set(foxes);
  }

  public void changeNutrition(String name, Food food, Drink drink) {
    Fox fox = getByName(name);
    fox.setFood(food);
    fox.setDrink(drink);
  }

  public void learnTrick(String name, Trick trick) {
    if (trick == null) {
      return;
    }
    getByName(name).learTrick(trick);
  }

  public Trick[] getNewTricks(String name) {
    Fox fox = getByName(name);
    return Arrays.stream(Trick.values())
        .filter(fox::isNewTrick)
        .toArray(Trick[]::new);
  }

  public boolean isNotAuthorized(String name) {
    return name == null || name.isEmpty() || !exists(name);
  }

  private boolean exists(String name) {
    return foxes.stream()
        .map(Fox::getName)
        .anyMatch(n -> n.equals(name));
  }

}
