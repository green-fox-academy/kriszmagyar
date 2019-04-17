class Animal {
  private int hunger;
  private int thirst;

  int getHunger() {
    return hunger;
  }

  int getThirst() {
    return thirst;
  }

  Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  void eat() {
    hunger--;
  }

  void drink() {
    thirst--;
  }

  void play() {
    hunger++;
    thirst++;
  }
}
