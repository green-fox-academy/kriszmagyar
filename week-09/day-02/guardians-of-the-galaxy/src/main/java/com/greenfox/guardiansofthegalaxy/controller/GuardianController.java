package com.greenfox.guardiansofthegalaxy.controller;

import com.greenfox.guardiansofthegalaxy.model.Translation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @GetMapping("/groot")
  public Translation groot(@RequestParam String message) {
    return new Translation();
  }

}
