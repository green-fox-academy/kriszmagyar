package com.greenfox.foxclub.model;

import com.greenfox.foxclub.model.store.Store;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fox {

  private String name;
  private int level;
  private String type;
  private Mood mood;
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
    mood = new Mood(100);
    tricks = new HashSet<>();
    actions = new ArrayList<>();
    store = new Store(actions);
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
