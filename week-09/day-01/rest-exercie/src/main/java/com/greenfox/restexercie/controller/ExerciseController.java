package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.model.CustomError;
import com.greenfox.restexercie.model.Doubler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

  @GetMapping("/doubling")
  public ResponseEntity doubling(Integer input) {
    if (input == null) {
      return ResponseEntity.badRequest().body(new CustomError("Please provide an input!"));
    }
    return ResponseEntity.ok().body(new Doubler(input));
  }

}
