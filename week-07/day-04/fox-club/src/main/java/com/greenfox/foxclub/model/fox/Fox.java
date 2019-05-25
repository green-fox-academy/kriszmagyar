package com.greenfox.foxclub.model.fox;

import com.greenfox.foxclub.model.store.Store;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Fox {

  private static final int PERIOD_IN_SEC = 5;

  private String name;
  private Level level;
  private String type;
  private Mood mood;
  private Energy energy;
  private Set<Trick> tricks;
  private List<Action> actions;
  private Store store;

  public Fox() {
    this("");
  }

  public Fox(String name) {
    this.name = name;
    actions = new ArrayList<>();
    level = new Level();
    type = "Otter";
    mood = new Mood(80);
    energy = new Energy(80);
    tricks = new HashSet<>();
    store = new Store(actions);
    start();
  }

  private void start() {
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        periodicActivity();
      }
    }, PERIOD_IN_SEC * 1000, PERIOD_IN_SEC * 1000);
  }

  private void periodicActivity() {
    store.doEat();
    store.doDrink();
    mood.changeLevel(calcLevelChange(-1, -10, 2));
    energy.changeLevel(calcLevelChange(2, -5, 1));
    store.changeFavorits();
  }

  private int calcLevelChange(int start, int emptyStore, int favoriteFood) {
    int change = start;
    if (store.getCurrentFood() == 0) {
      change += emptyStore;
    }
    if (store.getCurrentDrink() == 0) {
      change += emptyStore;
    }
    if (store.getFood() == store.getFavoriteFood()) {
      change += favoriteFood;
    }
    return change;
  }

  public void learTrick(Trick trick) {
    if (trick.reqLevel > level.get()) {
      actions.add(new Action("You have to be at least level " + trick.reqLevel
          + " to learn " + trick.name));
      return;
    }
    tricks.add(trick);
    actions.add(new Action(trick));
  }

  public void performTrick(Trick trick) {
    if (trick.reqEnergy > energy.getLevel()) {
      actions.add(new Action("You need at least " + trick.reqEnergy
        + " energy to perform " + trick.name));
      return;
    }
    mood.changeLevel(trick.moodBoost);
    energy.changeLevel(-trick.reqEnergy);
    level.addXP(trick.reqLevel);
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

  public Level getLevel() {
    return level;
  }

  public String getType() {
    return type;
  }

  public Mood getMood() {
    return mood;
  }

  public Energy getEnergy() {
    return energy;
  }

  public Set<Trick> getTricks() {
    return tricks;
  }

  public List<Action> getActions() {
    return actions;
  }

  public Store getStore() {
    return store;
  }

  @Override
  public String toString() {
    return String.format("This is %s. Currently living on %s and %s. Knows %s tricks.",
        name, store.getFood(), store.getDrink(), tricks.size()
    );
  }
}
