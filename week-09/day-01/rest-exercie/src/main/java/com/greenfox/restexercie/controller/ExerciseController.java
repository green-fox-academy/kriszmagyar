package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

  @GetMapping("/doubling")
  public Doubler doubling(Integer input) {
    return new Doubler(input);
  }

  @GetMapping("/greeter")
  public ResponseEntity greeter(Greeter greeter) {
    return ResponseEntity.ok().body(greeter.getWelcomeMessage());
  }

}
