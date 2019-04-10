import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinesToCenter{
  private static void mainDraw(Graphics graphics){

    // Create a line drawing function that takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Fill the canvas with lines from the edges, every 20 px, to the center.

    int grow = 20;
    int x = 0;
    int y = 0;

    while (x <= WIDTH) {
      drawLine(graphics, x, 0);
      drawLine(graphics, x, HEIGHT);
      x += grow;
    }

    while (y <= HEIGHT) {
      drawLine(graphics, 0, y);
      drawLine(graphics, WIDTH, y);
      y += grow;
    }

  }

  private static void drawLine(Graphics grapics, int x, int y) {
    int centerX = WIDTH / 2;
    int centerY = HEIGHT / 2;
    grapics.setColor(Color.black);
    grapics.drawLine(x, y, centerX, centerY);
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