package com.greenfoxacademy.lionkingbank.model;

public class BankAccount {

  private static int nextId = 1;

  private String id;
  private String name;
  private double balance;
  private String animalType;

  public BankAccount(String name, double balance, String animalType) {
    id = animalType + nextId++;
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
