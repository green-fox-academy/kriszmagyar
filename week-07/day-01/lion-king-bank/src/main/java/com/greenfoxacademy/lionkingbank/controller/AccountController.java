package com.greenfoxacademy.lionkingbank.controller;

import com.greenfoxacademy.lionkingbank.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

  @GetMapping("/accounts/show")
  public String getAccount(Model model) {
    model.addAttribute("account",
        new BankAccount("Simba", 2000.0, "lion"));
    return "account";
  }

}
