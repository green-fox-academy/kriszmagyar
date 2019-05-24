package com.greenfox.foxclub.model;

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

  public void changeLevel(int change) {
    level = Math.max(Math.min(level + change, MAX_LEVEL), 0);
    setType();
  }

  public MoodType getType() {
    return type;
  }

  private void setType() {
    if (level > 75) {
      type = MoodType.HAPPY;
    } else {
      type = MoodType.ANGRY;
    }
  }

  public enum MoodType {

    HAPPY ("Happy", "far fa-laugh-beam"),
    ANGRY ("Angry", "far fa-angry");

    public final String name;
    public final String icon;

    MoodType(String name, String icon) {
      this.name = name;
      this.icon = icon;
    }

    @Override
    public String toString() {
      return name;
    }
  }

}
