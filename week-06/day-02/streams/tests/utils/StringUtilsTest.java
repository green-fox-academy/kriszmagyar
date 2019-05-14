package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void getUppercaseShouldReturnUppercaseChars() {
    assertArrayEquals(new char[]{'G', 'F'}, StringUtils.getUppercase("GreenFox"));
  }

}