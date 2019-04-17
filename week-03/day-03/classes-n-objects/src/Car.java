public class Car {

  private int gasAmount;
  private int capacity;

  Car() {
    this.gasAmount = 0;
    this.capacity = 100;
  }

  int fill() {
    int missingAmount = this.capacity - this.gasAmount;
    this.gasAmount = this.capacity;
    return missingAmount;
  }
}
