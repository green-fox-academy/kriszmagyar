package com.greenfox.guardiansofthegalaxy.model;

public class Translation {

  private String recieved;
  private String translated;

  public Translation() {
  }

  public Translation(String recieved) {
    this.recieved = recieved;
    this.translated = "I'm Groot";
  }

  public String getRecieved() {
    return recieved;
  }

  public void setRecieved(String recieved) {
    this.recieved = recieved;
  }

  public String getTranslated() {
    return translated;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
}
