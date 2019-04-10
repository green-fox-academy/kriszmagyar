import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingSquares {
  private static void mainDraw(Graphics graphics){

    // drawRainbow(graphics, 400);
    // drawPurpleSteps(graphics, 20, 5);
    drawCheckBoard(graphics);

  }

  private static void drawRainbow(Graphics graphics, int n) {
    for (int i = 0; i < n; i++) {

      int size = (int) (Math.random() * WIDTH - i);
      int x = getCordToCenter(size, WIDTH);
      int y = getCordToCenter(size, HEIGHT);
      Color color = getRandom();
      drawSquare(graphics, size, color);
    }
  }

  private static void drawPurpleSteps(Graphics graphics, int n, int grow) {
    int size = 25;
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      graphics.setColor(new Color(128,0,128));
      drawSquare(graphics, size, x, y, true);
      size += grow;
      x += size - grow;
      y = x;
    }
  }

  private static void drawCheckBoard(Graphics graphics) {
    int size = (int) (WIDTH / 8);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {

        if ((i + j) % 2 == 0) {
          graphics.setColor(Color.white);
        } else {
          graphics.setColor(Color.black);
        }

        int x = size * i;
        int y = size * j;
        drawSquare(graphics, size, x, y);

      }
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

  private static void drawSquare(Graphics graphics, int size, int x, int y, boolean border) {
    drawSquare(graphics, size, x, y);
    drawBorder(graphics, size, x, y);
  }

  private static void drawBorder(Graphics graphics, int size, int x, int y) {
    graphics.setColor(Color.black);
    graphics.drawPolygon(new int[] {x, x + size, x + size, x, x}, new int[] {y, y, y + size, y + size, y}, 5);
  }

  private static int getCordToCenter(int size, int sizeOfCanvas) {
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