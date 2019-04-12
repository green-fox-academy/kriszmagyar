import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  private static void draw(Graphics graphics){

    int size = 32;
    int numbOfLines = 26;

    drawLines(graphics, size, numbOfLines);
  }

  private static void drawLines(Graphics graphics, int size, int n) {

    for (int i = 0; i < n; i++) {
      int x1 = i * size / 2;
      int y1 = (int) (HEIGHT - i * size / Math.sqrt(2));
      int x2 = WIDTH - i * size / 2;
      int y2 = y1;
      graphics.drawLine(x1, y1, x2, y2);
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
