package airforce;

import java.util.ArrayList;
import java.util.List;

class Carrier {

  private List<Aircraft> aircrafts = new ArrayList<>();
  private int ammoStore;
  private int health;

  Carrier(int ammoStore, int health) {
    this.ammoStore = ammoStore;
    this.health = health;
  }

  void add(Aircraft aircraft) {
    this.aircrafts.add(aircraft);
  }

  void fight(Carrier otherCarrier) {
    int damage = 0;
    for (Aircraft aircraft : aircrafts) {
      damage += aircraft.fight();
    }
    otherCarrier.damage(damage);
  }

  private void damage(int amount) {
    this.health = Math.max(this.health - amount, 0);
  }

  private int getDamage() {
    int damage = 0;
    for (Aircraft aircraft : aircrafts) {
      damage += aircraft.getDamage();
    }
    return damage;
  }

  void fill() throws Exception {
    if (isEmptyStorage()) {
      throw new Exception("Ammo store is empty!");
    }
    fillWithPriority(true);
    fillWithPriority(false);
  }

  private void fillWithPriority(boolean withPriority) {
    for (Aircraft aircraft : aircrafts) {
      if (aircraft.isPriority() || !withPriority) {
        this.ammoStore = aircraft.refill(this.ammoStore);
      }
    }
  }

  private boolean isEmptyStorage() {
    return this.ammoStore == 0;
  }

  private boolean isDead() {
    return this.health == 0;
  }

  String getStatus() {
    if (isDead()) {
      return "It's dead Jim :(";
    }

    String status = "HP: " + this.health + ", Aircraft count: " + this.aircrafts.size()
        + ", Ammo storage: " + this.ammoStore + ", Total damage: " + getDamage()
        + "\nAircrafts:\n\n";

    for (Aircraft aircraft : aircrafts) {
      status += aircraft.getStatus();
    }

    return status;
  }
}
