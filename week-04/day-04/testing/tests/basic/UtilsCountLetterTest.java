package basic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class UtilsCountLetterTest {

  @Test
  public void countLettersShouldReturnMapWithCountedLetters() {
    Map<Character, Integer> actual = Utils.countLetters("greenfox");
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('g', 1);
    expected.put('r', 1);
    expected.put('e', 2);
    expected.put('n', 1);
    expected.put('f', 1);
    expected.put('o', 1);
    expected.put('x', 1);
    assertEquals(expected, actual);
  }

  @Test
  public void countLettersShouldReturnMapWithCountedLetters2() {
    Map<Character, Integer> actual = Utils.countLetters("lettter");
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('l', 1);
    expected.put('e', 2);
    expected.put('t', 3);
    expected.put('r', 1);
    assertEquals(expected, actual);
  }

  @Test
  public void countLettersShouldReturnEmptyMap() {
    Map<Character, Integer> actual = Utils.countLetters("");
    Map<Character, Integer> expected = new HashMap<>();
    assertEquals(expected, actual);
  }

}
