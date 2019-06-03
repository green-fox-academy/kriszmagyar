package com.greenfox.restexercie.model;

import com.greenfox.restexercie.exceptions.DoublerInvalidInputException;

public class Doubler {

  private int received;
  private int result;

  public Doubler(Integer received) {
    if (received == null) {
      throw new DoublerInvalidInputException();
    }
    this.received = received;
    this.result = received * 2;
  }

  public int getReceived() {
    return received;
  }

  public void setReceived(int received) {
    this.received = received;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
