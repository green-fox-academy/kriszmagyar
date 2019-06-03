package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.exceptions.MissingInputException;
import com.greenfox.restexercie.model.Appenda;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import com.greenfox.restexercie.model.Result.Action;
import com.greenfox.restexercie.model.ResultDTO;
import com.greenfox.restexercie.model.UntilDTO;
import com.greenfox.restexercie.service.ExerciseService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/dountil/{action}")
  public ResultDTO doUntil(@PathVariable Action action, @Valid @RequestBody UntilDTO until,
      Errors errors) {
    if (errors.hasErrors()) {
      throw new MissingInputException("Please provide a number!");
    }
    return exerciseService.getResultDto(action, until);
  }
}
