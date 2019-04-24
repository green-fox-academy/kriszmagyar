package main.java.animals;

abstract class EggLayer extends Animal {

  EggLayer(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
