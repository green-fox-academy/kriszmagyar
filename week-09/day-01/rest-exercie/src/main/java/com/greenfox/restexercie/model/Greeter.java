package com.greenfox.restexercie.model;

public class Greeter {

  private String welcome_message;

  public Greeter(String name, String title) {
    welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
  }

  public String getWelcome_message() {
    return welcome_message;
  }
}
