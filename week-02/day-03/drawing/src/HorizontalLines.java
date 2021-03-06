import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines{
  private static void mainDraw(Graphics graphics){

    // Create a line drawing function that takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a 50 long horizontal line from that point.
    // Draw 3 lines with that function. Use loop for that.

    for (int i = 0; i < 3; i++) {
      int x = (int) (Math.random() * WIDTH);
      int y = (int) (Math.random() * HEIGHT);
      drawLine(graphics, x, y);
    }

  }

  private static void drawLine(Graphics grapics, int x, int y) {
    int lineWidth = 50;
    grapics.drawLine(x, y, x + lineWidth, y);
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