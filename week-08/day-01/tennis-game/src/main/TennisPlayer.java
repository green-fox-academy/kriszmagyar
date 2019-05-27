package main;

class TennisPlayer {

  private String name;
  private int point = 0;

  TennisPlayer(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  int getPoint() {
    return point;
  }

  void addPoint() {
    point++;
  }

  String getScore() {
    return new String[]{"Love", "Fifteen", "Thirty", "Forty"}[point];
  }
}
