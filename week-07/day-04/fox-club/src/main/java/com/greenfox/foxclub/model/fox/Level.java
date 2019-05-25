package com.greenfox.foxclub.model.fox;

public class Level {

  private int level;
  private int currentXP;
  private int requiredXP;

  Level() {
    level = 1;
    currentXP = 0;
    setRequiredXP();
  }

  public int get() {
    return level;
  }

  public int getCurrentXP() {
    return currentXP;
  }

  public void addXP(int amount) {
    currentXP += amount;
    if (currentXP > requiredXP) {
      levelUp();
    }
  }

  private void levelUp() {
    currentXP -= requiredXP;
    level++;
    setRequiredXP();
  }

  public int getRequiredXP() {
    return requiredXP;
  }

  private void setRequiredXP() {
    requiredXP = level * level * 10;
  }
}
