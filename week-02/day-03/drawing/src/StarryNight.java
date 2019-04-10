import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight{
  private static void mainDraw(Graphics graphics){

    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)
    drawNightSky(graphics, 200);

  }

  private static void drawNightSky(Graphics graphics, int numbOfStars) {
    drawBackground(graphics);
    drawAllStars(graphics, numbOfStars);
  }

  private static void drawBackground(Graphics graphics) {
    graphics.setColor(Color.black);
    graphics.fillRect(0, 0, WIDTH, HEIGHT);
  }

  private static void drawAllStars(Graphics graphics, int numbOfStars) {

    for (int i = 0; i < numbOfStars; i++) {
      int x = getRandCoordinate(WIDTH);
      int y = getRandCoordinate(HEIGHT);
      int size = getSize();
      Color color = getShadeOfGray();

      drawStar(graphics, x, y, size, color);
    }

  }

  private static void drawStar(Graphics graphics, int x, int y, int size, Color color) {
    graphics.setColor(color);
    graphics.fillRect(x, y, size, size);
  }

  private static int getRandCoordinate(int max) {
    return (int) (Math.random() * max);
  }

  private static int getSize() {
    int min = 2;
    int max = 8;
    return (int) (Math.random() * (max - min) + min);
  }

  private static Color getShadeOfGray() {
    int shade = (int) (Math.random() * 256);
    return new Color(shade, shade, shade);
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