import java.util.ArrayList;
import java.util.List;

public class Ship {

  private static final int MIN_CREW = 3;
  private static final int MAX_CREW = 6;

  private Pirate captain;
  private List<Pirate> crew;
  private boolean hasCrew = false;
  private int numbOfCrew = 0;

  /**
   * Filling the ship with a captain and random number of pirates.
   */
  void fill() {
    addCrew();
    addCaptain();
  }

  /**
   * Ships can have battles with each other.<br> The ship should win if its calculated score is
   * higher. Calculate score: Number of Alive pirates in the crew - Number of consumed rum by the
   * captain. The loser crew has a random number of losses (deaths). The winner captain and crew has
   * a party, including a random number of rum :)
   *
   * @return should return true if the actual ship (this) wins
   */
  boolean battle(Ship otherShip) {
    boolean isWinning = this.getBattleScore() >= otherShip.getBattleScore();
    if (isWinning) {
      winBattle();
      otherShip.looseBattle();
    } else {
      looseBattle();
      otherShip.winBattle();
    }
    return isWinning;
  }

  private void addCaptain() {
    this.captain = new Pirate();
  }

  private void addCrew() {
    this.numbOfCrew = calcNumbOfCrew();
    this.crew = initCrew(this.numbOfCrew);
    this.hasCrew = true;
  }

  private List<Pirate> initCrew(int numbOfCrew) {
    List<Pirate> crew = new ArrayList<>();
    for (int i = 0; i < numbOfCrew; i++) {
      crew.add(new Pirate());
    }
    return crew;
  }

  private int calcNumbOfCrew() {
    return (int) (Math.random() * (MAX_CREW - MIN_CREW + 1) + MIN_CREW);
  }

  private int getNumbOfCrew() {
    return this.numbOfCrew;
  }

  private int getNumbOfPassedOutInCrew() {
    int numbOfPassedOut = 0;
    for (Pirate pirate : this.crew) {
      if (pirate.isPassedOut()) {
        numbOfPassedOut++;
      }
    }
    return numbOfPassedOut;
  }

  private int getNumbOfDeadInCrew() {
    int numbOfDead = 0;
    for (Pirate pirate : this.crew) {
      if (pirate.isDead()) {
        numbOfDead++;
      }
    }
    return numbOfDead;
  }

  private int getBattleScore() {
    return getNumbOfCrew() - getNumbOfDeadInCrew() - this.captain.getDrunkLevel();
  }

  private void looseBattle() {
    int numbOfLosses = (int) (Math.random() * getNumbOfCrew() + 1);
    for (int i = 0; i < numbOfLosses; i++) {
      this.crew.get(i).die();
    }
  }

  private void winBattle() {
    int numbOfRums = (int) (Math.random() * 4 + 1);
    for (int i = 0; i < numbOfRums; i++) {
      drinkARound();
    }
  }

  private void drinkARound() {
    this.captain.drinkSomeRum();
    for (Pirate pirate : this.crew) {
      pirate.drinkSomeRum();
    }
  }

  @Override
  public String toString() {
    if (!this.hasCrew) {
      return "This ship has no crew.";
    }

    return "\nShip details:\n"
      + "------------------------------------------------------\n"
      + "The ship has a captain and " + getNumbOfCrew() + " crew members.\n"
      + "The captain has consumed " + this.captain.getDrunkLevel()
      + " rums and is " + this.captain.getState() + ".\n"
      + "There are " + getNumbOfPassedOutInCrew() + " passed out and "
      + getNumbOfDeadInCrew() + " dead pirates in the crew.\n"
      + "------------------------------------------------------\n";
  }

}
