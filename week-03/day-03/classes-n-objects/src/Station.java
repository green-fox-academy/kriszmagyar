public class Station {

  int gasAmount;

  Station(int gasAmount) {
    this.gasAmount = gasAmount;
  }

  void refill(Car car) {
    this.gasAmount -= car.fill();
  }

}
