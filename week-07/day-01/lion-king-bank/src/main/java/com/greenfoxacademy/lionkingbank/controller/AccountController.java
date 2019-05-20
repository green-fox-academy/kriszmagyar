package com.greenfoxacademy.lionkingbank.controller;

import com.greenfoxacademy.lionkingbank.model.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

  List<BankAccount> accounts = new ArrayList<>();

  @GetMapping("/")
  public String getAccounts(Model model) {
    model.addAttribute(accounts);
    return "accounts";
  }

  @GetMapping("/show")
  public String getAccount(Model model) {
    model.addAttribute("account",
        new BankAccount("Simba", 2000.0, "lion"));
    return "account";
  }

}
