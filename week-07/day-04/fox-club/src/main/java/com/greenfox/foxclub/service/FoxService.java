package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.fox.Action;
import com.greenfox.foxclub.model.fox.Fox;
import com.greenfox.foxclub.model.fox.Trick;
import com.greenfox.foxclub.model.store.Drink;
import com.greenfox.foxclub.model.store.Food;
import com.greenfox.foxclub.repository.FoxRepository;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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

  public void add(Fox fox) {
    foxes.add(fox);
    fr.set(foxes);
  }

  public void changeNutrition(String name, Food food, Drink drink) {
    Fox fox = getByName(name);
    fox.getStore().setFood(food);
    fox.getStore().setDrink(drink);
  }

  public void fillUpFood(String name) {
    getByName(name).getStore().fillUpFood();
  }

  public void fillUpDrink(String name) {
    getByName(name).getStore().fillUpDrink();
  }

  public void learnTrick(String name, Trick trick) {
    if (trick == null) {
      return;
    }
    getByName(name).learTrick(trick);
  }

  public void performTrick(String name, Trick trick) {
    if (trick == null) {
      return;
    }
    getByName(name).performTrick(trick);
  }

  public Trick[] getNewTricks(String name) {
    Fox fox = getByName(name);
    return Arrays.stream(Trick.values())
        .filter(fox::isNewTrick)
        .toArray(Trick[]::new);
  }

  public List<Action> getActions(String name) {
    return getByName(name).getActions().stream()
        .sorted(Comparator.comparing(Action::getDate).reversed())
        .collect(Collectors.toList());
  }

  public List<Action> getActions(String name, int limit) {
    return getActions(name).stream()
        .limit(limit)
        .collect(Collectors.toList());
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
