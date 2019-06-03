package com.greenfox.restexercie.model;

import javax.validation.constraints.NotNull;

public class UntilDTO {

  @NotNull
  private Integer until;

  public Integer getUntil() {
    return until;
  }

  public void setUntil(Integer until) {
    this.until = until;
  }
}
