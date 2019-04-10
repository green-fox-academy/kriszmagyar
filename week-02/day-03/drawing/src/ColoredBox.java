import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
  private static void mainDraw(Graphics graphics){
    // Draw a box that has different colored lines on each edge.
    graphics.setColor(Color.red);
    graphics.fillRect(50, 50, 50, 50);
    // TOP
    graphics.setColor(Color.green);
    graphics.drawLine(50, 50, 100, 50);
    // Right
    graphics.setColor(Color.blue);
    graphics.drawLine(100, 50, 100, 100);
    // Bottom
    graphics.setColor(Color.orange);
    graphics.drawLine(100, 100, 50, 100);
    // Left
    graphics.setColor(Color.cyan);
    graphics.drawLine(50, 100, 50, 50);

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