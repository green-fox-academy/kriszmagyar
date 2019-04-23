package garden;

class Plant {

  private String color;
  private boolean needsWater;
  private float absorbRate;
  private int currentWater;
  private int waterAmountRequired;

  Plant(String color) {
    this.color = color;
    this.needsWater = true;
    this.currentWater = 0;
  }

  void water(int amount) {
    this.currentWater += amount * this.absorbRate;
    setNeedsWater();
  }

  void setAbsorbRate(float absorbRate) {
    this.absorbRate = absorbRate;
  }

  void setWaterAmountRequired(int amount) {
    this.waterAmountRequired = amount;
  }

  boolean isNeedsWater() {
    return this.needsWater;
  }

  private void setNeedsWater() {
    if (currentWater >= waterAmountRequired) {
      this.needsWater = false;
    }
  }

  private String printNeedsWater() {
    return isNeedsWater() ? "needs water" : "doesnt need water";
  }

  @Override
  public String toString() {
    return "The " + this.color + " " + this.getClass().getSimpleName() + " " + printNeedsWater();
  }
}
