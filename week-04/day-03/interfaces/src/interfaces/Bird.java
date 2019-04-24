package interfaces;

import main.java.animals.EggLayer;

public class Bird extends EggLayer implements Flyable {

  Bird(String name) {
    super(name);
  }

  @Override
  public void fly() {
    System.out.println("Fly with wings");
  }

  @Override
  public void land() {
    System.out.println("Land with wings");
  }

  @Override
  public void takeOff() {
    System.out.println("Take off with wings");
  }
}
