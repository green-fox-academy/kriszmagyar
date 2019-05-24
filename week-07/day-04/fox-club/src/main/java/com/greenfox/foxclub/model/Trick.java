package com.greenfox.foxclub.model;

public enum Trick {

  CODE_IN_JAVA ("Code in Java"),
  WRITE_HTML ("Write HTML"),
  SUFFER_WITH_CSS ("Suffer with CSS"),
  PLAY_GAMES ("Play games"),
  WATCH_FIFTY_SHADES_OF_GRAY ("Watch fifty shades of gray"),
  BE_COOL_AS_A_CUCUMBER ("Be cool as a cucumber"),
  LAND_ON_MARS ("Land on mars");

  public final String name;

  Trick(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
