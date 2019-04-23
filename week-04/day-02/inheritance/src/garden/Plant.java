package garden;

class Plant {

  private String color;
  private boolean needsWater;

  Plant(String color) {
    this.color = color;
    this.needsWater = true;
  }

  private String getNeedsWater() {
    return needsWater ? "needs water" : "doesnt need water";
  }

  @Override
  public String toString() {
    return "The " + this.color + " " + this.getClass().getSimpleName() + " " + getNeedsWater();
  }
}
