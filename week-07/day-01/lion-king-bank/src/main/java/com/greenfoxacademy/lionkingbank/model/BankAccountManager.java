package com.greenfoxacademy.lionkingbank.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

  private List<BankAccount> accounts;

  public BankAccountManager() {
    accounts = new ArrayList<>();
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
  }

  public List<BankAccount> get() {
    return accounts;
  }

  public BankAccount getWithId(int id) {
    return accounts.stream()
        .filter(a -> a.getId() == id)
        .findAny()
        .orElse(null);
  }

}
