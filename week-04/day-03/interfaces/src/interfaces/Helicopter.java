package interfaces;

public class Helicopter extends Vehicle implements Flyable {

  public Helicopter(String type) {
    super(type);
    setNumbOfWheels(0);
  }

  @Override
  public void fly() {
    System.out.println("fly");
  }

  @Override
  public void land() {
    System.out.println("land");
  }

  @Override
  public void takeOff() {
    System.out.println("takeOff");
  }
}
