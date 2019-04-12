import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
  private static void draw(Graphics graphics){

    int numbOfLines = 20;

    graphics.setColor(Color.green);

    // Top Right
    for (int i = 0; i < numbOfLines; i++) {
      int y1 = i * HEIGHT / numbOfLines / 2;
      int x2 = i * WIDTH / numbOfLines / 2 + WIDTH / 2;
      graphics.drawLine(WIDTH / 2, y1, x2, HEIGHT / 2);
    }

    // Bottom Right
    for (int i = 0; i < numbOfLines; i++) {
      int y1 = i * HEIGHT / numbOfLines / 2 + HEIGHT / 2;
      int x2 = WIDTH - i * WIDTH / numbOfLines / 2;
      graphics.drawLine(WIDTH / 2, y1, x2, HEIGHT / 2);
    }

    // Bottom Left
    for (int i = 0; i <= numbOfLines; i++) {
      int x1 = i * WIDTH / numbOfLines / 2;
      int y2 = i * HEIGHT / numbOfLines / 2 + HEIGHT / 2;
      graphics.drawLine(x1, HEIGHT / 2, WIDTH / 2, y2);
    }

    // Top Left
    for (int i = 0; i < numbOfLines; i++) {
      int y1 = i * HEIGHT / numbOfLines / 2;
      int x2 = WIDTH / 2 - i * WIDTH / numbOfLines / 2;
      graphics.drawLine(WIDTH / 2, y1, x2, HEIGHT / 2);
    }

  }

  // Don't touch the code below
  private static final int WIDTH = 800;
  private static final int HEIGHT = 800;

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
