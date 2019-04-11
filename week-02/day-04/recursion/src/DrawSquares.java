import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawSquares {
  private static void draw(Graphics graphics){
    drawRecursiveSquares(graphics, 0, 0, WIDTH);
  }

  private static void drawRecursiveSquares(Graphics graphics, int parentX, int parentY, int parentSize) {

    if (parentSize == 0) {
      return;
    }

    graphics.drawRect(parentX, parentY, parentSize, parentSize);

    int size = parentSize / 3;
    int x, y;

    x = parentX + parentSize * 1 / 3;
    y = parentY + parentSize * 0 / 3;
    drawRecursiveSquares(graphics, x, y, size);

    x = parentX + parentSize * 2 / 3;
    y = parentY + parentSize * 1 / 3;
    drawRecursiveSquares(graphics, x, y, size);

    x = parentX + parentSize * 1 / 3;
    y = parentY + parentSize * 2 / 3;
    drawRecursiveSquares(graphics, x, y, size);

    x = parentX + parentSize * 0/ 3;
    y = parentY + parentSize * 1 / 3;
    drawRecursiveSquares(graphics, x, y, size);

  }

  // Don't touch the code below
  private static final int WIDTH = 729;
  private static final int HEIGHT = 729;

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