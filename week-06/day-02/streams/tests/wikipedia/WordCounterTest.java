package wikipedia;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {

  private WordCounter wc;
  private String text;

  @Before
  public void setUp() {
    wc = new WordCounter();
    text = "In the seven seven eight the the In!";
  }

  @Test
  public void countWordsShouldCountAllWords() {
    Map<String, Integer> expected = new HashMap<>();
    expected.put("in", 2);
    expected.put("the", 3);
    expected.put("seven", 2);
    expected.put("eight", 1);
    assertEquals(expected, wc.countWords(text));
  }

  @Test
  public void countWordsShouldCountThreeMostCommonWords() {
    Map<String, Integer> expected = new HashMap<>();
    expected.put("in", 2);
    expected.put("the", 3);
    expected.put("seven", 2);
    assertEquals(expected, wc.countWords(text, 3));
  }

  @Test
  public void countWordFromFileShouldReturnAllWords() {
    Map<String, Integer> expected = new HashMap<>();
    expected.put("in", 2);
    expected.put("the", 3);
    expected.put("seven", 2);
    expected.put("eight", 1);
    assertEquals(expected, wc.countWordsFromFile("src/wikipedia/test.txt"));
  }

  @Test
  public void runCountWordFromFile() {
    wc.countWordsFromFile("src/wikipedia/test.txt");
  }
}