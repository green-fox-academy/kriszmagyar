package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.exceptions.CustomError;
import com.greenfox.restexercie.exceptions.MissingInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExerciseAdvice {

  @ResponseBody
  @ExceptionHandler(MissingInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CustomError missingExceptionHandler(MissingInputException ex) {
    return new CustomError(ex.getMessage());
  }
}
