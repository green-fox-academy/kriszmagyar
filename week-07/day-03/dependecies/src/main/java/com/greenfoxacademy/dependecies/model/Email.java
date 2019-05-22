package com.greenfoxacademy.dependecies.model;

public class Email {

  private String text;
  private String color;

  public Email(String text, String color) {
    this.text = text;
    this.color = color;
  }

  public String getText() {
    return text;
  }

  public String getColor() {
    return color;
  }
}
