package com.greenfox.restexercie.util;

import java.util.Arrays;

public class ArrayUtils {

  public static int sum(int[] arr) {
    return Arrays.stream(arr).sum();
  }

  public static int multiply(int[] arr) {
    return Arrays.stream(arr)
        .reduce((n1, n2) -> n1 * n2)
        .orElse(0);
  }

  public static int[] doubling(int[] arr) {
    return Arrays.stream(arr)
        .map(i -> i * 2)
        .toArray();
  }

}
