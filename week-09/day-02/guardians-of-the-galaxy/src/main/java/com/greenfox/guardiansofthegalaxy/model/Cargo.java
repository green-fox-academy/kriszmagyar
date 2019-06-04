package com.greenfox.guardiansofthegalaxy.model;

public class Cargo {

  public static final int MAX_CALIBER = 12500;

  private int caliber25;
  private int caliber30;
  private int caliber50;
  private String shipStatus;
  private boolean ready;

  public Cargo() {
    setShipStatus();
  }

  public CargoFillResponse fill(String caliberSize, int amount) {
    setCaliber(caliberSize, amount);
    setShipStatus();
    setReady();
    return new CargoFillResponse(caliberSize, amount, shipStatus, ready);
  }

  private void setCaliber(String caliberSize, int amount) {
    switch (caliberSize) {
      case ".25":
        caliber25 += amount;
        break;
      case ".30":
        caliber30 += amount;
        break;
      case ".50":
        caliber50 += amount;
        break;
      default:
        throw new RuntimeException("Invalid caliber size!");
    }
  }

  private void setShipStatus() {
    int fillPercent = (caliber25 + caliber30 + caliber50) * 100 / MAX_CALIBER;
    if (fillPercent == 0) {
      shipStatus = "empty";
    } else if (fillPercent == 100) {
      shipStatus = "full";
    } else if (fillPercent > 100) {
      shipStatus = "overloaded";
    } else {
      shipStatus = fillPercent + "%";
    }
  }

  private void setReady() {
    ready = shipStatus.equals("full");
  }

  public int getCaliber25() {
    return caliber25;
  }

  public int getCaliber30() {
    return caliber30;
  }

  public int getCaliber50() {
    return caliber50;
  }

  public String getShipStatus() {
    return shipStatus;
  }

  public boolean isReady() {
    return ready;
  }
}
