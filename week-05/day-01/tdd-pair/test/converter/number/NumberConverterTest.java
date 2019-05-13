package converter.number;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NumberConverterTest {

  int money = 745;
  NumberConverter testConverter = new NumberConverter();

  @Test
  public void convertToSevenHundredFortyFive() {
    assertEquals("seven hundred and forty five dollars", testConverter.convert(money));
  }

}