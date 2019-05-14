package utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class IntUtilsTest {

  @Test
  public void getEvenShouldReturnEvenNumbers() {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> evenNumbers = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);
    assertEquals(evenNumbers, IntUtils.getEven(numbers));
  }

  @Test
  public void getSqrtShouldReturnSquaredNumbers() {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, 0);
    List<Double> squaredNumbers= Arrays.asList(1.0, Math.sqrt(3), Math.sqrt(2), 2.0, 0.0);
    assertEquals(squaredNumbers, IntUtils.getSqrt(numbers));
  }

  @Test
  public void getHighSquaresShouldReturnSquaredNumbersHigherThanGiven() {
    List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
    List<Integer> expected = Arrays.asList(81, 64, 36, 25);
    assertEquals(expected, IntUtils.getHighSquares(numbers, 20));
  }

  @Test
  public void getAvgOfOddShouldReturnOne() {
    List<Integer> numbers = Arrays.asList(1, 5, -3);
    assertEquals(1.0, IntUtils.getAvgOfOdd(numbers), 0.0001);
  }

  @Test
  public void getAvgOfOddShouldReturnTheAverageOfOddNumbers() {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    double expected = (double)(1 + 3 - 7 - 3 + 19 + 9) / 6;
    assertEquals(expected, IntUtils.getAvgOfOdd(numbers), 0.0001);
  }

  @Test
  public void getSumOfOddShouldReturnTheSumOfOddNumbers() {
    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    assertEquals(95, IntUtils.getSumOfOdd(numbers), 0.0001);
  }

}