package basic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsIsAnagramTest {

  @Test
  public void isAnagramShouldReturnTrueIfStringsAreAnagrams() {
    assertTrue(Utils.isAnagram("dog", "God"));
  }

  @Test
  public void isAnagramShouldReturnTrueIfStringsAreAnagrams2() {
    assertTrue(Utils.isAnagram("elbow", "below"));
  }

  @Test
  public void isAnagramShouldReturnFalseIfStringsAreNotAnagrams() {
    assertFalse(Utils.isAnagram("green", "fox"));
  }

}
