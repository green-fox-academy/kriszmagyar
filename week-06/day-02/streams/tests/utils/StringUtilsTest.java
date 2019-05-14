package utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void getUppercaseShouldReturnUppercaseChars() {
    assertEquals(Arrays.asList('G', 'F'), StringUtils.getUppercase("GreenFox"));
  }

  @Test
  public void getStartsWithShouldReturnRome() {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    assertEquals(Arrays.asList("ROME"), StringUtils.getStartsWith(cities, "R"));
  }

  @Test
  public void getStartsWithShouldReturnAmsterdamAndAbuDhabi() {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    assertEquals(Arrays.asList("AMSTERDAM", "ABU DHABI"), StringUtils.getStartsWith(cities, "A"));
  }

  @Test
  public void concatenateShouldReturnGreenFox() {
    assertEquals("GreenFox", StringUtils.concatenate("Green", Arrays.asList('F', 'o', 'x')));
  }

  @Test
  public void countLettersShouldReturnAMapWithCountedLetters() {
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('G', 1);
    expected.put('r', 1);
    expected.put('e', 2);
    expected.put('n', 1);
    assertEquals(expected, StringUtils.countLetters("Green"));
  }

}