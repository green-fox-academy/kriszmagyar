package com.greenfox.guardiansofthegalaxy.controller;

import com.greenfox.guardiansofthegalaxy.model.CustomError;
import com.greenfox.guardiansofthegalaxy.model.Translation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @GetMapping("/groot")
  public ResponseEntity groot(String message) {
    if (message == null) {
      return ResponseEntity.badRequest().body(new CustomError("I am Groot!"));
    }
    return ResponseEntity.ok().body(new Translation(message));
  }

}
