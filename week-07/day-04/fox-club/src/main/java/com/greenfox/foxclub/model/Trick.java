package com.greenfox.foxclub.model;

public enum Trick {

  CODE_IN_JAVA ("Code in Java", 1, 10, 10),
  WRITE_HTML ("Write HTML", 1, 3, 4),
  SUFFER_WITH_CSS ("Suffer with CSS", 1, -5, 12),
  PLAY_GAMES ("Play games", 2, 15, 5),
  WATCH_FIFTY_SHADES_OF_GRAY ("Watch fifty shades of gray", 2, -10, 20),
  BE_COOL_AS_A_CUCUMBER ("Be cool as a cucumber", 3, 0, 0),
  LAND_ON_MARS ("Land on mars", 3, 25, 15);

  public final String name;
  public final int reqLevel;
  public final int moodBoost;
  public final int reqEnergy;

  Trick(String name, int reqLevel, int moodBoost, int reqEnergy) {
    this.name = name;
    this.reqLevel = reqLevel;
    this.moodBoost = moodBoost;
    this.reqEnergy = reqEnergy;
  }

  @Override
  public String toString() {
    return name;
  }
}
