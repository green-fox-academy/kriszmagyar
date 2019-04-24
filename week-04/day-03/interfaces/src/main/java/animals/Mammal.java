package main.java.animals;

public class Mammal extends Animal {

  public Mammal(String name) {
    super(name);
    setHostile(false);
  }

  @Override
  public String breed() {
    return "pushing miniature versions out";
  }
}
