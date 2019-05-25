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

  public int getCurrentPercent() {
    return 100 * currentXP / requiredXP;
  }

  void addXP(int amount) {
    currentXP += amount;
    if (currentXP >= requiredXP) {
      levelUp();
    }
  }

  private void levelUp() {
    currentXP -= requiredXP;
    level++;
    setRequiredXP();
  }

  private void setRequiredXP() {
    requiredXP = level * level * 10;
  }
}
