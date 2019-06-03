package com.greenfox.restexercie.model;

public class ResultDTO {

  private int result;

  public ResultDTO(Result result) {
    this.result = result.getResult();
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
