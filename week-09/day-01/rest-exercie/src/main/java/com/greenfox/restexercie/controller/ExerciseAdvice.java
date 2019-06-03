package com.greenfox.restexercie.controller;

import com.greenfox.restexercie.exceptions.DoublerInvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExerciseAdvice {

  @ResponseBody
  @ExceptionHandler(DoublerInvalidInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String doublerBadRequestHandler(DoublerInvalidInputException ex) {
    return ex.getMessage();
  }

}
