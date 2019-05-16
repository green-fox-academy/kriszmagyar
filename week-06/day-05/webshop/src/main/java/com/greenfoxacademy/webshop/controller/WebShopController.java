package com.greenfoxacademy.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebShopController {

  @RequestMapping
  public String getWebShop() {
    return "webshop";
  }

}
