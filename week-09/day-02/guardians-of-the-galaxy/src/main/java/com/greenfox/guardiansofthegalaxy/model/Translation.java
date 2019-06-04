package com.greenfox.guardiansofthegalaxy.model;

public class Translation {

  private String received;
  private String translated;

  public Translation() {
  }

  public Translation(String received) {
    this.received = received;
    this.translated = "I am Groot!";
  }

  public String getReceived() {
    return received;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public String getTranslated() {
    return translated;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
}
