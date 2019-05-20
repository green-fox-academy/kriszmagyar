package com.greenfoxacademy.lionkingbank.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

  private List<BankAccount> accounts;

  public BankAccountManager() {
    accounts = new ArrayList<>();
    accounts.add(new BankAccount("Simba", 2000.0, "lion", true));
    accounts.add(new BankAccount("Timon", 100.0, "meerkat"));
    accounts.add(new BankAccount("Pumba", 150.0, "wordhog"));
    accounts.add(new BankAccount("Zazu", 1450.0, "hornbill"));
    accounts.add(new BankAccount("Mufasa", 10000.0, "lion", true));
    accounts.add(new BankAccount("Scar", 9850.0, "lion", true, true));
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

  public void add(BankAccount account) {
    accounts.add(account);
  }

  public void changeBalance(ChangeAccountInfo cai) {
    for (BankAccount account : accounts) {
      if (account.getId() == cai.getId()) {
        account.changeBalance(cai.isIncrement());
      }
    }
  }

}
