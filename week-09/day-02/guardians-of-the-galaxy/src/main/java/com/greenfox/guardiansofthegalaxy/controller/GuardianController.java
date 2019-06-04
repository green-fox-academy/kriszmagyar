package com.greenfox.guardiansofthegalaxy.controller;

import com.greenfox.guardiansofthegalaxy.model.Cargo;
import com.greenfox.guardiansofthegalaxy.model.CargoFillResponse;
import com.greenfox.guardiansofthegalaxy.model.CustomError;
import com.greenfox.guardiansofthegalaxy.model.Translation;
import com.greenfox.guardiansofthegalaxy.model.YonduArrow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  private Cargo cargo = new Cargo();

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
    return ResponseEntity.ok().body(cargo);
  }

  @GetMapping("/rocket/fill")
  public ResponseEntity fillCargo(String caliber, Integer amount) {
    if (caliber == null || amount == null) {
      return ResponseEntity.badRequest().body(new CustomError("Invalid parameters!"));
    }
    return ResponseEntity.ok().body(cargo.fill(caliber, amount));
  }
}
