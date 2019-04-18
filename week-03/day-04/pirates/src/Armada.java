import java.util.ArrayList;
import java.util.List;

public class Armada {

  private static final int MIN_FLEET = 4;
  private static final int MAX_FLEET = 10;

  private List<Ship> fleet;

  public Armada() {
    this.fleet = initFleet();
  }

  boolean war(Armada otherArmada) {
    System.out.println("War!");
    return true;
  }

  private List<Ship> initFleet() {
    List<Ship> fleet = new ArrayList<>();
    int numbOfShips = (int) (Math.random() * (MAX_FLEET - MIN_FLEET + 1) + MIN_FLEET);

    for (int i = 0; i < numbOfShips; i++) {
      fleet.add(new Ship());
    }

    return fleet;
  }
}
