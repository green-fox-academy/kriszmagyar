package basic;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SharpieTest {

  private Sharpie sharpie;

  @Before
  public void setup() {
    this.sharpie = new Sharpie("green", 10);
  }

  @Test
  public void sharpieInkAmountDecreaseAfterUsing() {
    int inkAmount = sharpie.getInkAmount();
    sharpie.use();
    assertTrue(sharpie.getInkAmount() < inkAmount);
  }

  @Test
  public void sharpieIsUsableAfterInit() {
    assertTrue(sharpie.isUsable());
  }

}
