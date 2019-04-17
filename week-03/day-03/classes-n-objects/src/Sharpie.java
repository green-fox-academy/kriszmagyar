public class Sharpie {
  private String color;
  private double width;
  private double inkAmount;

  public Sharpie(String color, double width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

  void use() {
    inkAmount--;
  }

  boolean isUsable() {
    return this.inkAmount > 0;
  }

  public double getInkAmount() {
    return inkAmount;
  }
}
