import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawHexagons {
  private static void draw(Graphics graphics){

    int x = WIDTH / 2;
    int y = HEIGHT / 2;
    int size = 256;
    
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
  private static final int WIDTH = 730;
  private static final int HEIGHT = 730;

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