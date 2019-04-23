package garden;

import java.util.ArrayList;
import java.util.List;

class Garden {
  private List<Plant> plants = new ArrayList<>();

  void add(Plant plant) {
    this.plants.add(plant);
  }
}
