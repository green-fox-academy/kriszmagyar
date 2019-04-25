package basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UtilsFibonacciTest {

  @Test
  public void fibonacciShouldReturnMemberOnGivenIndex() {
    assertEquals(5, Utils.fibonacci(5));
  }

  @Test
  public void fibonacciShouldReturnMemberOnHigherGivenIndex() {
    assertEquals(21, Utils.fibonacci(8));
  }

  @Test
  public void fibonacciShouldReturnZeroWhenIndexLessThanOne() {
    assertEquals(0, Utils.fibonacci(0));
  }

}
