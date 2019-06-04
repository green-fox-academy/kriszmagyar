package com.greenfox.guardiansofthegalaxy.model;

import javax.validation.constraints.NotEmpty;

public class FoodDTO {

  private static long currentId = 1;

  private long id;
  @NotEmpty
  private String name;
  private int amount;
  private int calorie;

  public FoodDTO() {
  }

  public FoodDTO(String name, int amount, int calorie) {
    this.id = currentId++;
    this.name = name;
    this.amount = amount;
    this.calorie = calorie;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getCalorie() {
    return calorie;
  }

  public void setCalorie(int calorie) {
    this.calorie = calorie;
  }
}
