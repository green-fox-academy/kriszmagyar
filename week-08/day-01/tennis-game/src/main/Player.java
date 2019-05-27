package main;

class Player {

  private String name;
  private int score = 0;

  Player(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  int getScore() {
    return score;
  }

  String getScoreMsg() {
    return new String[]{"Love", "Fifteen", "Thirty", "Forty"}[score];
  }

  void addScore() {
    score++;
  }
}
