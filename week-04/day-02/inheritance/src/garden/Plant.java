package garden;

class Plant {

  private String color;
  private boolean needsWater;
  private float absorbRate;
  private int currentWater;

  Plant(String color) {
    this.color = color;
    this.needsWater = true;
    this.currentWater = 0;
  }

  void setAbsorbRate(float absorbRate) {
    this.absorbRate = absorbRate;
  }

  private String getNeedsWater() {
    return needsWater ? "needs water" : "doesnt need water";
  }

  @Override
  public String toString() {
    return "The " + this.color + " " + this.getClass().getSimpleName() + " " + getNeedsWater();
  }
}
