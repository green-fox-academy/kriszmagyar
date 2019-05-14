package fox;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FoxTest {

  private FoxFinder ff;
  private List<Fox> foxes;
  
  @Before
  public void setup() {
    foxes = Arrays.asList(
      new Fox("Foxy1", "red", 11),
      new Fox("Foxy2", "green", 2),
      new Fox("Foxy3", "orange", 6),
      new Fox("Foxy4", "red", 3),
      new Fox("Foxy5", "green", 6)
    );
    ff = new FoxFinder();
  }

  @Test
  public void getWithColorShouldReturnFoxesWithGivenColor() {
    List<Fox> expected = Arrays.asList(
        new Fox("Foxy2", "green", 2),
        new Fox("Foxy5", "green", 6)
    );
    assertEquals(expected.toString(), ff.getWithColor(foxes, "green").toString());
  }

  @Test
  public void getWithColorAndAgeShouldReturnFoxesWithGivenColor() {
    List<Fox> expected = Arrays.asList(
        new Fox("Foxy2", "green", 2)
    );
    assertEquals(expected.toString(), ff.getWithColorAndAge(foxes, "green", 5).toString());
  }

  @Test
  public void countByColorShouldGroupFoxesByColor() {
    Map<String, Integer> expected = new HashMap<>();
    expected.put("red", 2);
    expected.put("green", 2);
    expected.put("orange", 1);
    assertEquals(expected, ff.countByColor(foxes));
  }
}




