package starwars;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;
import starwars.SWCharacter.Gender;

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
    assertEquals(179.23729, sw.getAvgHeight(Gender.MALE), 0.0001);
  }

  @Test
  public void getAvgHeightOfFemalesShouldBe() {
    assertEquals(165.47059, sw.getAvgHeight(Gender.FEMALE), 0.0001);
  }
}