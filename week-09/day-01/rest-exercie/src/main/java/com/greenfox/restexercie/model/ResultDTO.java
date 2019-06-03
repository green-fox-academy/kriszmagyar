package com.greenfox.restexercie.model;

public class ResultDTO <T> {

  private T result;

  public ResultDTO(T result) {
    this.result = result;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }
}
