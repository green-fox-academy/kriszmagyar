package garden;

import java.util.ArrayList;
import java.util.List;

class Garden {
  private List<Plant> plants = new ArrayList<>();

  void add(Plant plant) {
    this.plants.add(plant);
  }

  void water(int amount) {
    System.out.println("Watering with " + amount);
  }

  void printState() {
    for (Plant plant : plants) {
      System.out.println(plant);
    }
    System.out.println();
  }
}
