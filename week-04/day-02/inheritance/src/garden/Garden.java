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
    int numbOfPlantsNeedWater = getNumbOfPlantsNeedWater();

    for (Plant plant : plants) {
      if (plant.isNeedsWater()) {
        plant.water(amount / numbOfPlantsNeedWater);
      }
    }
  }

  private int getNumbOfPlantsNeedWater() {
    int counter = 0;
    for (Plant plant : plants) {
      if (plant.isNeedsWater()) {
        counter++;
      }
    }
    return counter;
  }

  void printState() {
    for (Plant plant : plants) {
      System.out.println(plant);
    }
    System.out.println();
  }
}
