package main;

public class TennisGame2 implements TennisGame {

  private TennisPlayer player1;
  private TennisPlayer player2;

  public TennisGame2(String name1, String name2) {
    player1 = new TennisPlayer(name1);
    player2 = new TennisPlayer(name2);
  }

  public void wonPoint(String name) {
    getPlayerByName(name).addPoint();
  }

  private TennisPlayer getPlayerByName(String name) {
    return player1.getName().equals(name) ? player1 : player2;
  }

  public String getScore() {
    return isNormalGame() ? normalScore() : tieBreakScore();
  }

  private boolean isNormalGame() {
    return player1.getPoint() < 4 && player2.getPoint() < 4;
  }

  private String normalScore() {
    return player1.getScore() + "-" + player2Score();
  }

  private String player2Score() {
    return player1.getPoint() == player2.getPoint() ? "All" : player2.getScore();
  }

  private String tieBreakScore() {
    return isDeuce() ? "Deuce" : advantageScore();
  }

  private boolean isDeuce() {
    return player1.getPoint() == player2.getPoint();
  }

  private String advantageScore() {
    return winOrAdvantage() + winningPlayer().getName();
  }

  private String winOrAdvantage() {
    return pointDifference() > 1 ? "Win for " : "Advantage ";
  }

  private int pointDifference() {
    return Math.abs(player1.getPoint() - player2.getPoint());
  }

  private TennisPlayer winningPlayer() {
    return player1.getPoint() > player2.getPoint() ? player1 : player2;
  }
}