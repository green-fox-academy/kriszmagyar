package basic;

import static org.junit.Assert.assertEquals;

import basic.CowsAndBulls.GameState;
import org.junit.Test;

public class CowsAndBullsTest {

  @Test
  public void goalShouldBeTheGivenInput() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    assertEquals(1234, cab.getGoal());
  }

  @Test
  public void numbOfGuessesShouldBeZeroOnStart() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    assertEquals(0, cab.getNumbOfGuesses());
  }

  @Test
  public void gameStateShouldBePlayingOnStart() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    assertEquals(GameState.PLAYING, cab.getState());
  }

  @Test
  public void numbOfGuessesShouldIncreaseWhenGuessing() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    cab.guess(9991);
    cab.guess(9992);
    cab.guess(9993);
    cab.guess(9994);
    assertEquals(4, cab.getNumbOfGuesses());
  }

  @Test
  public void gameStateShouldBeFinishedWhenGuessedCorrectly() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    cab.guess(1234);
    assertEquals(GameState.FINISHED, cab.getState());
  }

  @Test
  public void guessShouldReturnEmptyIfEveryDigitIsWrong() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    assertEquals("0 cow, 0 bull", cab.guess(5678));
  }

  @Test
  public void guessShouldReturnFourCowsIfEveryDigitIsCorrect() {
    CowsAndBulls cab = new CowsAndBulls(1234);
    assertEquals("4 cow, 0 bull", cab.guess(1234));
  }

  @Test
  public void guessShouldReturn1Cow2Bull() {
    CowsAndBulls cab = new CowsAndBulls(7624);
    assertEquals("1 cow, 2 bull", cab.guess(7296));
  }

  @Test
  public void guessShouldReturnWrongGuessIfDigitsAreMoreThanFour() {
    CowsAndBulls cab = new CowsAndBulls(7624);
    assertEquals("wrong guess", cab.guess(12345));
  }

  @Test
  public void guessShouldReturnWrongGuessIfDigitsAreLessThanFour() {
    CowsAndBulls cab = new CowsAndBulls(7624);
    assertEquals("wrong guess", cab.guess(123));
  }

}
