package starwars;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StarWarsTest {

  private StarWars sw;

  @Before
  public void setUp(){
    sw = new StarWars();
  }

  @Test
  public void heaviestShouldBeJabba() {
    assertEquals("Jabba Desilijic Tiure", sw.getNameOfHeaviest());
  }

  @Test
  public void getAvgHeightOfMalesShouldBe() {
    assertEquals(120.0, sw.getAvgHeightOfMales(), 0.0001);
  }
}