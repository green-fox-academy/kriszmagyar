import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
  private static void draw(Graphics graphics){

    int numbOfLines = 20;

    graphics.setColor(Color.green);
    for (int i = 0; i < numbOfLines; i++) {
      int y1 = i * HEIGHT / numbOfLines;
      int x2 = i * WIDTH / numbOfLines;
      graphics.drawLine(0, y1, x2, HEIGHT);
    }

    graphics.setColor(Color.red);
    for (int i = 0; i < numbOfLines; i++) {
      int y2 = i * HEIGHT / numbOfLines;
      int x1 = i * WIDTH / numbOfLines;
      graphics.drawLine(x1, 0, WIDTH, y2);
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
