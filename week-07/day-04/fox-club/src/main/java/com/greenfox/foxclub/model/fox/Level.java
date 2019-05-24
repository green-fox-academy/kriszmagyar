package com.greenfox.foxclub.model.fox;

public class Level {

  private int level;
  private int currentXP;
  private int requiredXP;

  Level() {
    level = 1;
    currentXP = 0;
    requiredXP = 10;
  }

  public int get() {
    return level;
  }

  public int getCurrentXP() {
    return currentXP;
  }

  public int getRequiredXP() {
    return requiredXP;
  }
}
