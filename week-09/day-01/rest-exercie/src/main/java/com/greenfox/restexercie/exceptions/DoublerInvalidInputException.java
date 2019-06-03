package com.greenfox.restexercie.exceptions;

public class DoublerInvalidInputException extends RuntimeException {

  public DoublerInvalidInputException() {
    super("Please provide an input!");
  }
}
