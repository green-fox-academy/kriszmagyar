import java.util.ArrayList;
import java.util.List;

public class Ship {

  private static final int MIN_CREW = 3;
  private static final int MAX_CREW = 6;

  private Pirate captain;
  private List<Pirate> crew;
  private boolean hasCrew = false;
  private int numbOfCrew = 0;

  void fill() {
    addCrew();
    addCaptain();
  }

  boolean battle(Ship otherShip) {
    if (this.getBattleScore() >= otherShip.getBattleScore()) {
      winBattle();
      otherShip.looseBattle();
      return true;
    } else {
      looseBattle();
      otherShip.winBattle();
      return false;
    }
  }

  private void addCaptain() {
    this.captain = new Pirate();
  }

  private void addCrew() {
    this.crew = new ArrayList<>();
    int numbOfCrew = calcNumbOfCrew();
    for (int i = 0; i < numbOfCrew; i++) {
      this.crew.add(new Pirate());
    }
    this.numbOfCrew = numbOfCrew;
    this.hasCrew = true;
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

    String details = "";
    details += "\nShip details:\n";
    details += "------------------------------------------------------\n";
    details += "The ship has a captain and " + getNumbOfCrew() + " crew members.\n";
    details += "The captain has consumed " + this.captain.getDrunkLevel()
        + " rums and is " + this.captain.getState() + ".\n";
    details += "There are " + getNumbOfPassedOutInCrew() + " passed out and "
        + getNumbOfDeadInCrew() + " dead pirates in the crew.\n";
    details += "------------------------------------------------------\n";

    return details;
  }

}
