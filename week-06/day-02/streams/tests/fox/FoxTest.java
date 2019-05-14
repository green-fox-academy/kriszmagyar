package fox;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
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
      new Fox("Foxy5", "green", 4)
    );
    ff = new FoxFinder();
  }

  @Test
  public void getWithColorShouldReturnFoxesWithGivenColor() {
    List<Fox> expected = Arrays.asList(
        new Fox("Foxy2", "green", 2),
        new Fox("Foxy5", "green", 4)
    );
    assertEquals(expected.toString(), ff.getWithColor(foxes, "green").toString());
  }
}