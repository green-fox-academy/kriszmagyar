package main;

public class TennisGame3 implements TennisGame {

  private Player player1;
  private Player player2;

  public TennisGame3(String playerName1, String playerName2) {
    player1 = new Player(playerName1);
    player2 = new Player(playerName2);
  }

  public void wonPoint(String playerName) {
    getPlayerByName(playerName).addScore();
  }

  private Player getPlayerByName(String name) {
    return player1.getName().equals(name) ? player1 : player2;
  }

  public String getScore() {
    return isNormalGame() ? normalGameScoreMsg() : tieBreakScoreMsg();
  }

  private boolean isNormalGame() {
    return player1.getScore() < 4 && player2.getScore() < 4;
  }

  private String normalGameScoreMsg() {
    return player1.getScoreMsg() + "-" + player2ScoreMsg();
  }

  private String player2ScoreMsg() {
    return isDeuce() ? "All" : player2.getScoreMsg();
  }

  private boolean isDeuce() {
    return player1.getScore() == player2.getScore();
  }

  private String tieBreakScoreMsg() {
    return isDeuce() ? "Deuce" : inAdvanceMsg();
  }

  private String inAdvanceMsg() {
    return advantageOrWinningMsg() + winningPlayer().getName();
  }

  private String advantageOrWinningMsg() {
    return scoreDifference() > 1 ? "Win for " : "Advantage ";
  }

  private int scoreDifference() {
    return Math.abs(player1.getScore() - player2.getScore());
  }

  private Player winningPlayer() {
    return player1.getScore() > player2.getScore() ? player1 : player2;
  }
}