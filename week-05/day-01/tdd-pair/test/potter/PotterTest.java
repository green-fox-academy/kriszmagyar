package potter;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class PotterTest {

  private static final double DELTA = 0.001;

  private Potter potter;
  private Map<String, Integer> order;

  @Before
  public void setup() {
    potter = new Potter();
    order = new HashMap<>();
  }

  @Test
  public void getCostShouldReturnEightForOneBook() {
    order.put("first", 1);
    assertEquals(8, potter.getCost(order), DELTA);
  }

  @Test
  public void getCostShouldReturnSixteenForTwoSameBooks() {
    order.put("first", 2);
    assertEquals(16, potter.getCost(order), DELTA);
  }

  @Test
  public void getCostShouldReturnSixteenMinusDiscountForTwoDifferentBooks() {
    order.put("first", 1);
    order.put("second", 1);
    assertEquals(16 * 0.95, potter.getCost(order), DELTA);
 }

//  @Test
//  public void getCostShouldReturnForExample() {
//    order.put("first", 2);
//    order.put("second", 2);
//    order.put("third", 2);
//    order.put("fourth", 1);
//    order.put("fifth", 1);
//    assertEquals(51.20, potter.getCost(order), DELTA);
//  }

}