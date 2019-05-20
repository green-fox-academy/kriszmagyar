package com.greenfoxacademy.lionkingbank.controller;

import com.greenfoxacademy.lionkingbank.model.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

  List<BankAccount> accounts;

  public AccountController() {
    accounts = new ArrayList<>();
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
    accounts.add(new BankAccount("Simba", 2000.0, "lion"));
  }

  @GetMapping("")
  public String getAccounts(Model model) {
    model.addAttribute("accounts", accounts);
    return "accounts";
  }

  @GetMapping("/{id}")
  public String getAccount(Model model, @PathVariable int id) {
    model.addAttribute("account",
        accounts.stream().filter(a -> a.getId() == id).findAny().orElse(null));
    return "account";
  }

}
