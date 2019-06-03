package com.greenfox.restexercie.service;

import com.greenfox.restexercie.exceptions.MissingInputException;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

  public Doubler getDoublerInstance(Integer input) {
    if (input == null) {
      throw new MissingInputException("Please provide an input!");
    }
    return new Doubler(input);
  }

  public Greeter getGreeterInstance(String name, String title) {
    if (name == null) {
      throw new MissingInputException("Please provide a name!");
    }
    if (title == null) {
      throw new MissingInputException("Please provide a title!");
    }
    return new Greeter(name, title);
  }
}
