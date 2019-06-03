package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.exceptions.MissingInputException;
import com.greenfox.restexercie.model.Appenda;
import com.greenfox.restexercie.model.ArrayHandler;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import com.greenfox.restexercie.model.Log;
import com.greenfox.restexercie.model.LogEntries;
import com.greenfox.restexercie.model.LogQuery;
import com.greenfox.restexercie.model.Result.Action;
import com.greenfox.restexercie.model.ResultDTO;
import com.greenfox.restexercie.model.UntilDTO;
import com.greenfox.restexercie.service.ExerciseService;
import com.greenfox.restexercie.service.LogService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

  private final ExerciseService exerciseService;
  private final LogService logService;

  public ExerciseController(ExerciseService exerciseService,
      LogService logService) {
    this.exerciseService = exerciseService;
    this.logService = logService;
  }

  @GetMapping("/doubling")
  public Doubler doubling(@NotNull Integer input) {
    logService.save(new Log("/doubling", "input=" + input));
    return exerciseService.getDoublerInstance(input);
  }

  @GetMapping("/greeter")
  public Greeter greeter(String name, String title) {
    logService.save(new Log("/greeter", "name=" + name + ", title=" + title));
    return exerciseService.getGreeterInstance(name, title);
  }

  @GetMapping("/appenda")
  public ResponseEntity appendWithoutPath() {
    logService.save(new Log("/appenda", ""));
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/appenda/{appendable}")
  public Appenda appenda(@PathVariable String appendable) {
    logService.save(new Log("/appenda/" + appendable, ""));
    return new Appenda(appendable);
  }

  @PostMapping("/dountil/{action}")
  public ResultDTO doUntil(@PathVariable Action action, @Valid @RequestBody UntilDTO until,
      Errors errors) {
    if (errors.hasErrors()) {
      throw new MissingInputException("Please provide a number!");
    }
    logService.save(new Log("/dountil/" + action, until.toString()));
    return exerciseService.getResultDto(action, until);
  }

  @PostMapping("/arrays")
  public ResultDTO arrays(@Valid @RequestBody ArrayHandler arrayHandler, Errors errors) {
    if (errors.hasErrors()) {
      throw new MissingInputException("Please provide what to do with the numbers!");
    }
    logService.save(new Log("/arrays", arrayHandler.toString()));
    return exerciseService.getArrayResultsDto(arrayHandler);
  }

  @GetMapping("/log")
  public LogEntries findAllLogs(LogQuery logQuery) {
    System.out.println(logQuery.getCount());
    System.out.println(logQuery.getPage());
    System.out.println(logQuery.getQ());
    return logService.findAllLogs();
  }
}
