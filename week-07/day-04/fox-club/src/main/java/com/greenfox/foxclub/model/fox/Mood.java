package com.greenfox.foxclub.model.fox;

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
    if (level > 90) {
      type = MoodType.EXCELLENT;
    } else if (level > 75) {
      type = MoodType.HAPPY;
    } else if (level > 40) {
      type = MoodType.MEH;
    } else if (level > 25) {
      type = MoodType.ANGRY;
    } else {
      type = MoodType.SAD;
    }
  }

  public enum MoodType {

    EXCELLENT("Excellent", "far fa-grin-stars"),
    HAPPY ("Happy", "far fa-laugh-beam"),
    MEH ("Meh", "far fa-meh"),
    ANGRY ("Angry", "far fa-angry"),
    SAD ("Sad", "far fa-sad-cry");

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
