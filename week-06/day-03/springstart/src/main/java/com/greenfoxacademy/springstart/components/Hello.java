package com.greenfoxacademy.springstart.components;

public class Hello {

  private static final int MIN_FONT_SIZE = 10;
  private static final int MAX_FONT_SIZE = 30;

  private String text;
  private String color;
  private int fontSize;

  public Hello(String text) {
    this.text = text;
    color = initColor();
    fontSize = initFontSize();
  }

  private String initColor() {
    return String.format("rgba(%s, %s, %s)", getRGBValue(), getRGBValue(), getRGBValue());
  }

  private int getRGBValue() {
    return (int) (Math.random() * 256);
  }

  private int initFontSize() {
    return (int) (Math.random() * (MAX_FONT_SIZE - MIN_FONT_SIZE + 1) + MIN_FONT_SIZE);
  }

  public String getText() {
    return text;
  }

  public String getStyle() {
    return "font-size:" + fontSize + "px;color:" + color;
  }

}
