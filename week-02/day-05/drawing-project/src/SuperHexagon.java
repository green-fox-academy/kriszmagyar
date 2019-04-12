import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
  private static void draw(Graphics graphics){

    int x = WIDTH / 2;
    int y = HEIGHT / 2;
    int size = 64;
    int numbOfLayers = 2;

    drawTerrain(graphics, x, y, size, numbOfLayers);

  }

  private static void drawTerrain(Graphics graphics, int x, int y, int size, int numbOfLayers) {

    // Draw the in the middle
    drawHexagon(graphics, x, y, size);

    int height = (int) (size / Math.tan(Math.PI / 6));
    int numbOfHexagons = 1 * 6;

//    for (int i = 0; i < numbOfHexagons; i++) {
//      int x1 = x + (int) (sign(Math.sin(i * Math.PI * 2 / numbOfHexagons)) * size * 1.5);
//      int y1 = y - (int) (Math.cos(i * Math.PI * 2 / numbOfHexagons) * height);
//      drawHexagon(graphics, x1, y1, size);
//    }

    numbOfHexagons = 2 * 6;
    for (int i = 0; i < numbOfHexagons; i++) {
      int x1 = x + (int) (Math.sin(i * Math.PI * 2 / numbOfHexagons) * size * 1.5 * 2);
      int y1 = y - (int) (Math.cos(i * Math.PI * 2 / numbOfHexagons) * height * 2);
      drawHexagon(graphics, x1, y1, size);
    }
  }

  private static int sign(double num) {
    if (num < 0.00001 && num > -0.00001) {
      return 0;
    }
    if (num >=0.001) {
      return 1;
    }
    return -1;
  }

  private static void drawHexagon(Graphics graphics, int x, int y, int size) {
    drawRegularPolygon(graphics, x, y, size, 6);
  }

  /**
   * Draw a regular polygon with a given parameters.
   *
   * @param graphics The Graphics object which takes care about the actual drawing.
   * @param x The x coordinate of the center of the polygon.
   * @param y The y coordinate of the center of the polygon.
   * @param size The length of the side.
   * @param n The number of sides.
   */
  private static void drawRegularPolygon(Graphics graphics, int x, int y, int size, int n) {

    int[] xPoints = new int[n];
    int[] yPoints = new int[n];

    for (int i = 0; i < n; i++) {

      int xDiff = (int) (Math.cos(2 * Math.PI / n * i) * size);
      int yDiff = (int) (Math.sin(2 * Math.PI / n * i) * size);

      xPoints[i] = x + xDiff;
      yPoints[i] = y + yDiff;

    }

    graphics.drawPolygon(xPoints, yPoints, n);
  }

  // Don't touch the code below
  private static final int WIDTH = 1024;
  private static final int HEIGHT = 1024;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Draw Squares");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      draw(graphics);
    }
  }
}
