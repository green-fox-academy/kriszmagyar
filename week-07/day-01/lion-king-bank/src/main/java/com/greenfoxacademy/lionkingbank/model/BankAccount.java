package com.greenfoxacademy.lionkingbank.model;

public class BankAccount {

  private static int nextId = 1;

  private int id;
  private String name;
  private double balance;
  private String animalType;
  private boolean isKing;

  public BankAccount() {
    this("", 0.0, "", false);
  }

  BankAccount(String name, double balance, String animalType) {
    this(name, balance, animalType, false);
  }

  BankAccount(String name, double balance, String animalType, boolean isKing) {
    id = nextId++;
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = isKing;
  }

  public int getId() {
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

  public boolean isKing() {
    return isKing;
  }

  public void setIsKing(boolean king) {
    isKing = king;
  }
}
