import java.util.ArrayList;
import java.util.List;

class Farm {

  private List<Animal> animals;
  private int slots;

  Farm() {
    this.animals = new ArrayList<>();
    this.slots = 10;
  }

  void breed() {
    breed(new Animal());
  }

  void breed(Animal animal) {
    if (!isFull()) {
      animals.add(animal);
      slots--;
    }
  }

  void slaughter() {
    int maxHunger = 0;
    int maxIndex = 0;

    for (int i = 0; i < animals.size(); i++) {
      if (animals.get(i).getHunger() > maxHunger) {
        maxHunger = animals.get(i).getHunger();
        maxIndex = i;
      }
    }
    animals.remove(maxIndex);
  }

  private boolean isFull() {
    return this.slots == 0;
  }
}
