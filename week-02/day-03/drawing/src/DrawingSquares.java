import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingSquares {
  private static void mainDraw(Graphics graphics){

    // draw four different size and color rectangles.
    // avoid code duplication.
    for (int i = 0; i < 400; i++) {

      int size = (int) (Math.random() * WIDTH - i);
      int x = getCord(size, WIDTH);
      int y = getCord(size, HEIGHT);
      Color color = getRandom();
      drawSquare(graphics, size, color);
    }

  }

  private static void drawSquare(Graphics graphics, int size) {
    int x = WIDTH / 2 - size / 2;
    int y = HEIGHT / 2 - size / 2;
    drawSquare(graphics, size, x, y);
  }

  private static void drawSquare(Graphics graphics, int size, Color color) {
    graphics.setColor(color);
    drawSquare(graphics, size);
  }

  private static void drawSquare(Graphics graphics, int size, int x, int y) {
    graphics.fillRect(x, y, size, size);
  }

  private static int getCord(int size, int sizeOfCanvas) {
    return Math.max((int) (Math.random() * sizeOfCanvas - size), 0);
  }

  private static Color getRandom() {
    int red = (int) (Math.random() * 256);
    int green = (int) (Math.random() * 256);
    int blue = (int) (Math.random() * 256);
    return new Color(red, green, blue);
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