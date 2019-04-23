package garden;

class Flower extends Plant {

  Flower(String color) {
    super(color);
    setAbsorbRate(0.75f);
    setWaterAmountRequired(5);
  }
}
