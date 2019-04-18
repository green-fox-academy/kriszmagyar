import java.util.ArrayList;
import java.util.List;

public class Armada {

  private static final int MIN_FLEET = 4;
  private static final int MAX_FLEET = 10;

  private List<Ship> fleet;

  public Armada() {
    this.fleet = initFleet();
  }

  /**
   * Two armada can engage in a war.<br>
   * The first ship from the first armada battles the first of the other.
   * The loser gets skipped so the next ship comes in play from that armada.
   * Whichever armada gets to the end of its ships loses the war.
   *
   * @return  true if this is the winner
   */
  boolean war(Armada enemy) {
    System.out.println("War!");
    return true;
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
