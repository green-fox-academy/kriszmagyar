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
  public void getSquaredShouldReturnSquaredNumbers() {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, 0);
    List<Double> squaredNumbers= Arrays.asList(1.0, Math.sqrt(3), Math.sqrt(2), 2.0, 0.0);
    assertEquals(squaredNumbers, IntUtils.getSquared(numbers));
  }

}