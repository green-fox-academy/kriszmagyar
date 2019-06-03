package com.greenfox.restexercie.service;

import com.greenfox.restexercie.exceptions.MissingInputException;
import com.greenfox.restexercie.model.ArrayHandler;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import com.greenfox.restexercie.model.Result;
import com.greenfox.restexercie.model.Result.Action;
import com.greenfox.restexercie.model.ResultDTO;
import com.greenfox.restexercie.model.UntilDTO;
import com.greenfox.restexercie.util.ArrayUtils;
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

  public ResultDTO<Integer> getResultDto(Action action, UntilDTO until) {
    Result result = new Result(action, until.getUntil());
    return new ResultDTO<>(result.getResult());
  }

  public ResultDTO getArrayResultsDto(ArrayHandler arrayHandler) {
    switch (arrayHandler.getWhat()) {
      case "sum":
        return new ResultDTO<>(ArrayUtils.sum(arrayHandler.getNumbers()));
      case "multiply":
        return new ResultDTO<>(ArrayUtils.multiply(arrayHandler.getNumbers()));
      case "double":
        return new ResultDTO<>(ArrayUtils.doubling(arrayHandler.getNumbers()));
      default:
        throw new MissingInputException("Invalid command: " + arrayHandler.getWhat());
    }
  }
}
