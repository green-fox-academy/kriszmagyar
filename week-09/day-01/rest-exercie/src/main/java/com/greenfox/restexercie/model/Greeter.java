package com.greenfox.restexercie.model;

import com.greenfox.restexercie.exceptions.MissingInputException;

public class Greeter {

  private String name;
  private String title;
  private WelcomeMessage welcomeMessage;

  public Greeter(String name, String title) {
    if (name == null) {
      throw new MissingInputException("Please provide a name!");
    }
    if (title == null) {
      throw new MissingInputException("Please provide a title!");
    }
    welcomeMessage = new WelcomeMessage(name, title);
  }

  public WelcomeMessage getWelcomeMessage() {
    return welcomeMessage;
  }

  private class WelcomeMessage {

    private String welcome_message;

    WelcomeMessage(String name, String title) {
      welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
    }

    public String getWelcome_message() {
      return welcome_message;
    }
  }
}
