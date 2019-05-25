package com.greenfox.foxclub.model.fox;

import java.util.Arrays;
import java.util.Comparator;

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

  void changeLevel(int change) {
    level = Math.max(Math.min(level + change, MAX_LEVEL), 0);
    setType();
  }

  public EnergyType getType() {
    return type;
  }

  private void setType() {
    type = Arrays.stream(EnergyType.values())
        .filter(e -> level >= e.level)
        .sorted((e1, e2) -> e2.level - e1.level)
        .limit(1)
        .findFirst()
        .orElse(EnergyType.NORMAL);
  }

  public enum EnergyType {

    FULL_OF_LIFE ("Full of life", 75),
    NORMAL ("Normal", 40),
    TIRED ("Tired", 0);

    public final String name;
    public final int level;

    EnergyType(String name, int level) {
      this.name = name;
      this.level = level;

    }

    @Override
    public String toString() {
      return name;
    }
  }

}
