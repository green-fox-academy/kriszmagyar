import java.util.ArrayList;
import java.util.List;

public class Armada {

  private static final int MIN_FLEET = 4;
  private static final int MAX_FLEET = 10;

  private List<Ship> fleet;

  Armada() {
    this.fleet = initFleet();
  }

  /**
   * Two armada can engage in a war.<br> The first ship from the first armada battles the first of
   * the other. The loser gets skipped so the next ship comes in play from that armada. Whichever
   * armada gets to the end of its ships loses the war.
   *
   * @return true if this is the winner
   */
  boolean war(Armada enemy) {

    int ourCurrentShipIndex = 0;
    int enemyCurrentShipIndex = 0;

    while (true) {

      if (ourCurrentShipIndex >= this.fleet.size()) {
        return false;
      }

      if (enemyCurrentShipIndex >= enemy.fleet.size()) {
        return true;
      }

      Ship ourCurrentShip = this.fleet.get(ourCurrentShipIndex);
      Ship enemyCurrentShip = enemy.fleet.get(enemyCurrentShipIndex);

      if (ourCurrentShip.battle(enemyCurrentShip)) {
        enemyCurrentShipIndex++;
      } else {
        ourCurrentShipIndex++;
      }

    }
  }

  private List<Ship> initFleet() {
    List<Ship> fleet = new ArrayList<>();
    int numbOfShips = (int) (Math.random() * (MAX_FLEET - MIN_FLEET + 1) + MIN_FLEET);

    for (int i = 0; i < numbOfShips; i++) {
      Ship ship = new Ship();
      ship.fill();
      fleet.add(ship);
    }

    return fleet;
  }
}
