package com.greenfoxacademy.lionkingbank.controller;

import com.greenfoxacademy.lionkingbank.model.BankAccount;
import com.greenfoxacademy.lionkingbank.model.BankAccountManager;
import com.greenfoxacademy.lionkingbank.model.ChangeAccountInfo;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("/add")
  public String addAccountForm(Model model, BankAccount account) {
    model.addAttribute("account", account);
    return "add-account";
  }

  @PostMapping("/add")
  public String addAccount(BankAccount account) {
    bam.add(account);
    return "redirect:/accounts";
  }

  @PostMapping("/changeBalance")
  public String changeBalance(@RequestBody @Valid ChangeAccountInfo cai) {
    bam.changeBalance(cai);
    return "redirect:/accounts";

  }

}
