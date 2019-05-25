package com.greenfox.foxclub.model.fox;

import java.util.Arrays;

public class Mood {

  private static final int MAX_LEVEL = 100;

  private int level;
  private MoodType type;

  public Mood(int level) {
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

  public MoodType getType() {
    return type;
  }

  private void setType() {
    type = Arrays.stream(MoodType.values())
        .filter(m -> level >= m.level)
        .sorted((m1, m2) -> m2.level - m1.level)
        .limit(1)
        .findFirst()
        .orElse(MoodType.MEH);
  }

  public enum MoodType {

    EXCELLENT("Excellent", "far fa-grin-stars", 90),
    HAPPY("Happy", "far fa-laugh-beam", 75),
    MEH("Meh", "far fa-meh", 40),
    ANGRY("Angry", "far fa-angry", 25),
    SAD("Sad", "far fa-sad-cry", 0);

    public final String name;
    public final String icon;
    public final int level;

    MoodType(String name, String icon, int level) {
      this.name = name;
      this.icon = icon;
      this.level = level;
    }

    @Override
    public String toString() {
      return name;
    }
  }

}
