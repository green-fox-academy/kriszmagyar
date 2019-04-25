package basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

public class ExtensionTest {

  private Extension extension = new Extension();

  @Test
  public void testAdd_2and3is5() {
    assertEquals(5, extension.add(2, 3));
  }

  @Test
  public void testAdd_1and4is5() {
    assertEquals(5, extension.add(1, 4));
  }

  @Test
  public void testAdd_20and5is25() {
    assertEquals(25, extension.add(20, 5));
  }

  @Test
  public void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  public void testMaxOfThree_second() {
    assertEquals(10, extension.maxOfThree(8, 10, 3));
  }

  @Test
  public void testMaxOfThree_third() {
    assertEquals(5, extension.maxOfThree(3, 4, 5));
  }

  @Test
  public void testMedian_four() {
    assertEquals(5.0, extension.median(Arrays.asList(7,5,3,5)), 0.01);
  }

  @Test
  public void testMedian_five() {
    assertEquals(3.0, extension.median(Arrays.asList(1,2,3,4,5)), 0.01);
  }

  @Test
  public void testMedian_even() {
    assertEquals(2.5, extension.median(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 4, 5)), 0.01);
  }

  @Test
  public void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  public void testIsVowel_u() {
    assertTrue(extension.isVowel('u'));
  }

  @Test
  public void testIsVowel_c() {
    assertFalse(extension.isVowel('c'));
  }

  @Test
  public void testIsVowel_A() {
    assertTrue(extension.isVowel('A'));
  }

  @Test
  public void testTranslate_bemutatkozik() {
    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
  }

  @Test
  public void testTranslate_lagopus() {
    assertEquals("lavagovopuvus", extension.translate("lagopus"));
  }
}