package main.java.animals;

abstract class Animal {

  private String name;
  private int age;
  private int numbOfLegs;
  private boolean isHostile;

  Animal(String name) {
    this.name = name;
    this.numbOfLegs = 4;
  }

  public String getName() {
    return this.name;
  }

  void setNumbOfLegs(int numbOfLegs) {
    this.numbOfLegs = numbOfLegs;
  }

  void setHostile(boolean hostile) {
    isHostile = hostile;
  }

  public abstract String breed();
}
