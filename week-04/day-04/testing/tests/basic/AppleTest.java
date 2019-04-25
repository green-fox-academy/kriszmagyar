package basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class AppleTest {

  private Apple apple;

  @Before
  public void setup() {
    this.apple = new Apple();
  }

  @Test
  public void getAppleReturnsApple() {
    assertEquals("apple", this.apple.getApple());
  }

  @Test
  public void getAppleNotReturnsEmpty() {
    assertNotEquals("", this.apple.getApple());
  }

}
