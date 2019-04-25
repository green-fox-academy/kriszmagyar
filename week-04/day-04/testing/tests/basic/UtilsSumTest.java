package basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class UtilsSumTest {

  private List<Integer> list;

  @Test
  public void sumShouldAddNumbers() {
    this.list = new ArrayList<>(Arrays.asList(2, 5, 1, 2));
    assertEquals(10, Utils.sum(this.list));
  }

  @Test
  public void sumShouldAddMoreNumbers() {
    this.list = new ArrayList<>(Arrays.asList(200, 150, 50));
    assertEquals(400, Utils.sum(this.list));
  }

  @Test
  public void sumShouldReturn0WhenListIsEmpty() {
    this.list = new ArrayList<>();
    assertEquals(0, Utils.sum(this.list));
  }

  @Test
  public void sumShouldReturnIntWhenListHasOneElement() {
    this.list = new ArrayList<>(Arrays.asList(5));
    assertEquals(5, Utils.sum(this.list));
  }

  @Test
  public void sumShouldReturn0WhenListIsNull() {
    assertEquals(0, Utils.sum(this.list));
  }

}
