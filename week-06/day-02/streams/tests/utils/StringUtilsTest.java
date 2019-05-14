package utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void getUppercaseShouldReturnUppercaseChars() {
    List<Character> chars = Arrays.asList('G', 'F');
    assertEquals(chars, StringUtils.getUppercase("GreenFox"));
  }

}