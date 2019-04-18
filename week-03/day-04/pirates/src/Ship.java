import java.util.List;

public class Ship {

  private static final int MIN_CREW = 3;
  private static final int MAX_CREW = 6;

  private List<Pirate> crew;
  private Pirate captain;

  void fillShip() {
    addCrew();
    addCaptain();
  }

  private void addCaptain() {
    this.captain = new Pirate();
  }

  private void addCrew() {
    int numbOfCrew = calcNumbOfCrew();
    for (int i = 0; i < numbOfCrew; i++) {
      this.crew.add(new Pirate());
    }
  }

  private int calcNumbOfCrew() {
    return (int) (Math.random() * (MAX_CREW - MIN_CREW + 1) + MIN_CREW);
  }

}
