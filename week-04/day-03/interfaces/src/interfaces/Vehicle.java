package interfaces;

abstract class Vehicle {

  private String type;
  private int numbOfWheels;
  private int speed;

  Vehicle(String type) {
    this.type = type;
    this.speed = 0;
  }

  void setNumbOfWheels(int numbOfWheels) {
    this.numbOfWheels = numbOfWheels;
  }
}
