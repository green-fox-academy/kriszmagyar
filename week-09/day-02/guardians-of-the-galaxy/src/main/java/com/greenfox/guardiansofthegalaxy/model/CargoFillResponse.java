package com.greenfox.guardiansofthegalaxy.model;

public class CargoFillResponse {

  private String received;
  private int amount;
  private String shipStatus;
  private boolean ready;

  public CargoFillResponse(String received, int amount, String shipStatus, boolean ready) {
    this.received = received;
    this.amount = amount;
    this.shipStatus = shipStatus;
    this.ready = ready;
  }

  public String getReceived() {
    return received;
  }

  public int getAmount() {
    return amount;
  }

  public String getShipStatus() {
    return shipStatus;
  }

  public boolean isReady() {
    return ready;
  }
}
