import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  private static void draw(Graphics graphics){

    int x = WIDTH / 2;
    int y = HEIGHT / 2;
    int size = 256;
    int rotation = 60;

    drawTriangleRecursive(graphics, x, y, size, rotation);

  }

  private static void drawTriangleRecursive(Graphics graphics, int x, int y, int size, int rotation) {

    if (size < 20) {
      return;
    }

    // Draw the main triangle
    drawTriangle(graphics, x, y, size, rotation);

    // Middle
    drawTriangleRecursive(graphics, x, y, size / 2, rotation + 120);

    // Right
    drawTriangleRecursive(graphics, (int) (x + size / 2.3), y + size / 4, size / 2, rotation);

    // Left
    drawTriangleRecursive(graphics, (int) (x - size / 2.3), y + size / 4, size / 2, rotation);

    // Top
    drawTriangleRecursive(graphics, x, y - size / 2, size / 2, rotation);

  }

  private static void drawTriangle(Graphics graphics, int x, int y, int size, int rotation) {
    drawRegularPolygon(graphics, x, y, size, 3, rotation);
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
  private static void drawRegularPolygon(Graphics graphics, int x, int y, int size, int n, int rotation) {

    int[] xPoints = new int[n];
    int[] yPoints = new int[n];

    for (int i = 0; i < n; i++) {

      double rotate = Math.PI * rotation / 360;
      int xDiff = (int) (Math.cos(2 * Math.PI / n * i + rotate) * size);
      int yDiff = (int) (Math.sin(2 * Math.PI / n * i + rotate) * size);

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
