package com.greenfox.guardiansofthegalaxy.controller;

import com.greenfox.guardiansofthegalaxy.model.Cargo;
import com.greenfox.guardiansofthegalaxy.model.CustomError;
import com.greenfox.guardiansofthegalaxy.model.Translation;
import com.greenfox.guardiansofthegalaxy.model.YonduArrow;
import com.greenfox.guardiansofthegalaxy.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @Autowired
  private GuardianService guardianService;

  @GetMapping("/groot")
  public ResponseEntity groot(String message) {
    if (message == null) {
      return ResponseEntity.badRequest().body(new CustomError("I am Groot!"));
    }
    return ResponseEntity.ok().body(new Translation(message));
  }

  @GetMapping("/yondu")
  public ResponseEntity yondu(Double distance, Double time) {
    if (distance == null || time == null || time == 0) {
      return ResponseEntity.badRequest().body(new CustomError("Invalid parameters!"));
    }
    return ResponseEntity.ok().body(new YonduArrow(distance, time));
  }

  @GetMapping("/rocket")
  public ResponseEntity getCargo() {
    return ResponseEntity.ok().body(guardianService.getCargo());
  }

  @GetMapping("/rocket/fill")
  public ResponseEntity fillCargo(String caliber, Integer amount) {
    if (caliber == null || amount == null) {
      return ResponseEntity.badRequest().body(new CustomError("Invalid parameters!"));
    }
    return ResponseEntity.ok().body(guardianService.getCargo().fill(caliber, amount));
  }
}
