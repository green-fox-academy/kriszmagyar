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

  public double getInkAmount() {
    return inkAmount;
  }
}
