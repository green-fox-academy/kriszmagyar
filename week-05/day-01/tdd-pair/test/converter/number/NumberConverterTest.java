package converter.number;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NumberConverterTest {

  private NumberConverter testConverter = new NumberConverter();

  @Test
  public void convertToSevenHundredFortyFive() {
    assertEquals("seven hundred and forty five dollars", testConverter.convert(745));
  }

  @Test
  public void convertToEleven() {
    assertEquals("eleven dollars", testConverter.convert(11));
  }

  @Test
  public void convertToEightySix(){
    assertEquals("eighty six dollars", testConverter.convert(86));
  }

  @Test
  public void convertToHundredTwelve(){
    assertEquals("one hundred and twelve dollars", testConverter.convert(112));
  }

}