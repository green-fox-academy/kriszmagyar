package main;

public class TennisGame1 implements TennisGame {

  private static final int TIE_BREAK_SCORE = 4;

  private Player player1;
  private Player player2;

  public TennisGame1(String player1Name, String player2Name) {
    player1 = new Player(player1Name);
    player2 = new Player(player2Name);
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(player1.getName())) {
      player1.addScore();
    } else {
      player2.addScore();
    }
  }

  public String getScore() {
    if (playersHaveSameScore()) {
      return sameScoreMsg(player1.getScore());
    }
    if (playersAreInTieBreak()) {
      return tieBreakScoreMsg();
    }
    return defaultScoreMsg();
  }

  private boolean playersHaveSameScore() {
    return player1.getScore() == player2.getScore();
  }

  private String sameScoreMsg(int score) {
    if (score >= TIE_BREAK_SCORE) {
      return "Deuce";
    } else {
      return getSingleScoreMsg(score) + "-All";
    }
  }

  private boolean playersAreInTieBreak() {
    return player1.getScore() >= TIE_BREAK_SCORE
        || player2.getScore() >= TIE_BREAK_SCORE;
  }

  private String tieBreakScoreMsg() {
    return advantageOrWinMsg() + getPlayerInAdvance().getName();
  }

  private String advantageOrWinMsg() {
    if (getScoreDifference() > 1) {
      return "Win for ";
    } else {
      return "Advantage ";
    }
  }

  private Player getPlayerInAdvance() {
    return player1.getScore() > player2.getScore() ? player1 : player2;
  }

  private int getScoreDifference() {
    return Math.abs(player1.getScore() - player2.getScore());
  }

  private String defaultScoreMsg() {
    return getSingleScoreMsg(player1.getScore()) + "-"
        + getSingleScoreMsg(player2.getScore());
  }

  private String getSingleScoreMsg(int score) {
    switch (score) {
      case 1:
        return "Fifteen";
      case 2:
        return "Thirty";
      case 3:
        return "Forty";
      default:
        return "Love";
    }
  }
}