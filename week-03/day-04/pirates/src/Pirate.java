public class Pirate {

  private static final int MAX_SOBER_LEVEL = 4;

  private int drunkLevel = 0;
  private boolean isPassedOut = false;
  private boolean isDead = false;

  void drinkSomeRum() {
    if (this.isDead) {
      System.out.println("He's dead.");
      return;
    }
    this.drunkLevel++;
  }

  void howsItGoingMate() {
    if (isDrunk()) {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      this.passOut();
    } else {
      System.out.println("Pour me anudder! I just had " + this.drunkLevel + " drinks.");
    }
  }

  /**
   * Where pirate fights another pirate (if that other pirate is alive)
   * and there's a 1/3 chance, 1 dies, the other dies or they both pass out.
   */
  void brawl(Pirate anotherPirate) {
    if (this.isDead || anotherPirate.isDead) {
      System.out.println("Dead pirates can't fight!");
      return;
    }

    int outcome = (int) (Math.random() * 3);
    switch (outcome) {
      case 0: this.passOut(); anotherPirate.passOut();
      case 1: this.die();
      case 2: anotherPirate.die();
    }

  }

  String getState() {
    if (this.isDead) {
      return "dead";
    }
    if (this.isPassedOut) {
      return "passed out";
    }
    if (this.isDrunk()) {
      return "feeling drunk";
    }
    return "feeling good";
  }

  void die() { this.isDead = true; }

  private void passOut() { this.isPassedOut = true; }

  private boolean isDrunk() { return this.drunkLevel > MAX_SOBER_LEVEL; }

  int getDrunkLevel() { return this.drunkLevel; }

  boolean isPassedOut() { return this.isPassedOut; }

  boolean isDead() { return this.isDead; }

}
