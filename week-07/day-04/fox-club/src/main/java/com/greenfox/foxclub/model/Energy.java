package com.greenfox.foxclub.model;

public class Energy {

  private static final int MAX_LEVEL = 100;

  private int level;
  private EnergyType type;

  public Energy(int level) {
    this.level = Math.min(level, MAX_LEVEL);
    setType();
  }

  public int getLevel() {
    return level;
  }

  public void changeLevel(int change) {
    level = Math.max(Math.min(level + change, MAX_LEVEL), 0);
    setType();
  }

  public EnergyType getType() {
    return type;
  }

  private void setType() {
    if (level > 75) {
      type = EnergyType.FULL_OF_LIFE;
    } else {
      type = EnergyType.TIRED;
    }
  }

  public enum EnergyType {

    FULL_OF_LIFE ("Full of life"),
    TIRED ("Tired");

    public final String name;

    EnergyType(String name) {
      this.name = name;

    }

    @Override
    public String toString() {
      return name;
    }
  }

}
