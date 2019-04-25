package basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MathUtilsTest {

  private List<Integer> list;

  @Test
  public void sumShouldAddNumbers() {
    this.list = new ArrayList<>(Arrays.asList(2, 5, 1, 2));
    assertEquals(10, MathUtils.sum(this.list));
  }

  @Test
  public void sumShouldAddMoreNumbers() {
    this.list = new ArrayList<>(Arrays.asList(200, 150, 50));
    assertEquals(400, MathUtils.sum(this.list));
  }

  @Test
  public void sumShouldReturn0WhenListIsEmpty() {
    this.list = new ArrayList<>();
    assertEquals(0, MathUtils.sum(this.list));
  }

  @Test
  public void sumShouldReturnIntWhenListHasOneElement() {
    this.list = new ArrayList<>(Arrays.asList(5));
    assertEquals(5, MathUtils.sum(this.list));
  }

  @Test
  public void sumShouldReturn0WhenListIsNull() {
    assertEquals(0, MathUtils.sum(this.list));
  }

}
