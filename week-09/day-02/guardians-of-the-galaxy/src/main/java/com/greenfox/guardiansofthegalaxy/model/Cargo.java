package com.greenfox.guardiansofthegalaxy.model;

public class Cargo {

  public static final int MAX_CALIBER = 12500;

  private int caliber25;
  private int caliber30;
  private int caliber50;
  private String shipStatus;
  private boolean ready;

  public Cargo() {
    shipStatus = "empty";
  }

  public CargoFillResponse fill(double caliberSize, int amount) {
    setCaliber(caliberSize, amount);
    setShipStatus();
    setReady();
    return new CargoFillResponse(Double.toString(caliberSize), amount, shipStatus, ready);
  }

  private void setCaliber(double caliberSize, int amount) {

  }

  private void setShipStatus() {
    shipStatus = "50%";
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
