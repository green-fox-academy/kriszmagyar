import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectDots{
  private static void mainDraw(Graphics graphics){

    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    connectDots(graphics, new int[][] {{10, 10}, {290,  10}, {290, 290}, {10, 290}});
    connectDots(graphics, new int[][] {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}});

  }

  private static void connectDots(Graphics graphics ,int[][] points) {
    int[] xPoints = new int[points.length];
    int[] yPoints = new int[points.length];

    for (int i = 0; i < points.length; i++) {
      xPoints[i] = points[i][0];
      yPoints[i] = points[i][1];
    }

    graphics.drawPolygon(xPoints, yPoints, points.length);
  }

  // Don't touch the code below
  private static final int WIDTH = 320;
  private static final int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}