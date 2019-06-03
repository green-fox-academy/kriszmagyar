package com.greenfox.restexercie.model;

public class Result {

  private Action action;
  private int until;
  private int result;

  public Result(Action action, int until) {
    this.action = action;
    this.until = until;
    setResult();
  }

  int getResult() {
    return result;
  }

  private void setResult() {
    switch (action) {
      case sum:
        result = getResultSum();
        break;
      case factor:
        result = getResultFactor();
        break;
    }
  }

  private int getResultSum() {
    int result = 0;
    for (int i = 0; i <= until; i++) {
      result += i;
    }
    return result;
  }

  private int getResultFactor() {
    int result = 1;
    for (int i = 1; i <= until; i++) {
      result *= i;
    }
    return result;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public int getUntil() {
    return until;
  }

  public void setUntil(int until) {
    this.until = until;
  }

  public enum Action {
    sum, factor
  }
}
