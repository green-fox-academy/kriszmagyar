package com.greenfox.restexercie.exceptions;

public class CustomException {

  private String error;

  public CustomException(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
