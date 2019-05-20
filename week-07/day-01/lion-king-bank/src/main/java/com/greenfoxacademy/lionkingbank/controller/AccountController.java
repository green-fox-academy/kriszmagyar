package com.greenfoxacademy.lionkingbank.controller;

import com.greenfoxacademy.lionkingbank.model.BankAccountManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

  private BankAccountManager bam = new BankAccountManager();

  @GetMapping("")
  public String getAccounts(Model model) {
    model.addAttribute("accounts", bam.get());
    return "accounts";
  }

  @GetMapping("/{id}")
  public String getAccount(Model model, @PathVariable int id) {
    model.addAttribute("account", bam.getWithId(id));
    return "account";
  }

}
