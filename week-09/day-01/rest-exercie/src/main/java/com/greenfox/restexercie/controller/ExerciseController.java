package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.model.Appenda;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import com.greenfox.restexercie.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

  @Autowired
  private ExerciseService exerciseService;

  @GetMapping("/doubling")
  public Doubler doubling(Integer input) {
    return exerciseService.getDoublerInstance(input);
  }

  @GetMapping("/greeter")
  public Greeter greeter(String name, String title) {
    return exerciseService.getGreeterInstance(name, title);
  }

  @GetMapping("/appenda")
  public ResponseEntity appendWithoutPath() {
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/appenda/{appendable}")
  public Appenda appenda(@PathVariable String appendable) {
    return new Appenda(appendable);
  }
}
