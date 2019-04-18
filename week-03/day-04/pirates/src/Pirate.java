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

  void brawl(Pirate anotherPirate) {
    if (this.isDead || anotherPirate.isDead) {
      System.out.println("Dead pirates can't fight!");
      return;
    }

    int outcome = (int) (Math.random() * 3);
    if (outcome == 0) {
      this.passOut();
      anotherPirate.passOut();
    }
    if (outcome == 1) {
      this.die();
    }
    if (outcome == 2) {
      anotherPirate.die();
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
