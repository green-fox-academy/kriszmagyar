package basic;

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
    if (isGuessCorrect(guessedNum)) {
      finish();
    }
    return "asd";
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
