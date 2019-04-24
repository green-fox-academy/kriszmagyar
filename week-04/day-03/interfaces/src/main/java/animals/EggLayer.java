package main.java.animals;

public abstract class EggLayer extends Animal {

  protected EggLayer(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
