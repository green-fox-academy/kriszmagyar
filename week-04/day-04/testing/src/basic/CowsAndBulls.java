package basic;

import java.util.ArrayList;
import java.util.List;

class CowsAndBulls {

  private int goal;
  private int numbOfGuesses;
  private GameState state;

  CowsAndBulls(int goal) {
    this.goal = goal;
    this.numbOfGuesses = 0;
    this.state = GameState.PLAYING;
  }

  String guess(int guessedNum) {
    this.numbOfGuesses++;

    if (guessedNum > 9999 || guessedNum < 1000) {
      return "wrong guess";
    }

    if (isGuessCorrect(guessedNum)) {
      finish();
    }

    int numbOfCows = getNumbOfCows(guessedNum);
    int numbOfBulls = getNumbOfBulls(guessedNum) - numbOfCows;

    return numbOfCows + " cow, " + numbOfBulls + " bull";
  }

  private int getNumbOfCows(int guessedNum) {
    int counter = 0;
    List<Integer> goalDigits = getDigits(this.goal);
    List<Integer> guessedNumDigits = getDigits(guessedNum);

    for (int i = 0; i < guessedNumDigits.size(); i++) {
      if (guessedNumDigits.get(i).equals(goalDigits.get(i))) {
        counter++;
      }
    }
    return counter;
  }

  private int getNumbOfBulls(int guessedNum) {
    int counter = 0;
    List<Integer> goalDigits = getDigits(this.goal);
    List<Integer> guessedNumDigits = getDigits(guessedNum);

    for (int i = 0; i < guessedNumDigits.size(); i++) {
      if (guessedNumDigits.contains(goalDigits.get(i))) {
        counter++;
      }
    }
    return counter;
  }

  private List<Integer> getDigits(int num) {
    List<Integer> digits = new ArrayList<>();
    while (num > 0) {
      digits.add(num % 10);
      num /= 10;
    }
    return digits;
  }

  private boolean isGuessCorrect(int guessedNum) {
    return guessedNum == this.goal;
  }

  private void finish() {
    this.state = GameState.FINISHED;
  }

  int getGoal() {
    return this.goal;
  }

  int getNumbOfGuesses() {
    return this.numbOfGuesses;
  }

  GameState getState() {
    return this.state;
  }

  enum GameState { PLAYING, FINISHED }

}
