package com.greenfox.restexercie.service;

import static com.greenfox.restexercie.util.ArrayUtils.doubling;
import static com.greenfox.restexercie.util.ArrayUtils.multiply;
import static com.greenfox.restexercie.util.ArrayUtils.sum;

import com.greenfox.restexercie.exceptions.MissingInputException;
import com.greenfox.restexercie.model.ArrayHandler;
import com.greenfox.restexercie.model.Doubler;
import com.greenfox.restexercie.model.Greeter;
import com.greenfox.restexercie.model.Result;
import com.greenfox.restexercie.model.Result.Action;
import com.greenfox.restexercie.model.ResultDTO;
import com.greenfox.restexercie.model.UntilDTO;
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
    String command = arrayHandler.getWhat();
    int[] numbers = arrayHandler.getNumbers();
    switch (command) {
      case "sum":
        return new ResultDTO<>(sum(numbers));
      case "multiply":
        return new ResultDTO<>(multiply(numbers));
      case "double":
        return new ResultDTO<>(doubling(numbers));
      default:
        throw new MissingInputException("Invalid command: " + command);
    }
  }
}
