package basic;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AnimalTest {

  private Animal animal;

  @Before
  public void setup() {
    this.animal = new Animal();
  }

  @Test
  public void eatShouldDecreaseHunger() {
    int prevHunger = animal.getHunger();
    animal.eat();
    assertTrue(animal.getHunger() < prevHunger);
  }

  @Test
  public void drinkShouldDecreaseThirst() {
    int prevThirst = animal.getThirst();
    animal.drink();
    assertTrue(animal.getThirst() < prevThirst);
  }

  @Test
  public void playShouldIncreaseThirst() {
    int prevThirst = animal.getThirst();
    animal.play();
    assertTrue(animal.getThirst() > prevThirst);
  }

  @Test
  public void playShouldIncreaseHunger() {
    int prevHunger = animal.getHunger();
    animal.play();
    assertTrue(animal.getHunger() > prevHunger);
  }

}
