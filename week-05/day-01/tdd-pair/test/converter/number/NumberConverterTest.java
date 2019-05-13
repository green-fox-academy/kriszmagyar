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

  @Test
  public void convertTo11(){
    assertEquals(11, testConverter.convert("eleven dollars"));
  }

  @Test
  public void convertTo86(){
    assertEquals(86, testConverter.convert("eighty six dollars"));
  }

  @Test
  public void covertToHundredAndEleven(){
    assertEquals(111, testConverter.convert("one hundred and eleven dollars"));
  }

  @Test
  public void convertToSevenHundredAndFortyFive(){
    assertEquals(745, testConverter.convert("seven hundred and forty five dollars"));
  }
}