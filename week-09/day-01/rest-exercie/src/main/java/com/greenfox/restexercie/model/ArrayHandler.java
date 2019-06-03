package com.greenfox.restexercie.model;

import java.util.Arrays;
import javax.validation.constraints.NotNull;

public class ArrayHandler {

  @NotNull
  private String what;
  @NotNull
  private int[] numbers;

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
  }

  @Override
  public String toString() {
    return "what=" + what + ", numbers=" + Arrays.toString(numbers);
  }
}
