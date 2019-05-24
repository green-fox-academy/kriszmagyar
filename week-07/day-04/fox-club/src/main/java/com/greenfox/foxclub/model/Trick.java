package com.greenfox.foxclub.model;

public enum Trick {

  CODE_IN_JAVA ("Code in Java"),
  WRITE_HTML ("Write HTML"),
  SUFFER_WITH_CSS ("Suffer with CSS");

  public final String name;

  Trick(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
