package com.greenfox.foxclub.model;

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
  private int level;
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
    level = 1;
    type = "Otter";
    mood = new Mood(80);
    energy = new Energy(80);
    tricks = new HashSet<>();
    actions = new ArrayList<>();
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
    mood.changeLevel(calcMoodLevelChange());
    energy.changeLevel(calcEnergyLevelChange());
  }

  private int calcMoodLevelChange() {
    return -1;
  }

  private int calcEnergyLevelChange() {
    return 2;
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

  public int getLevel() {
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
