import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicTacToe {

  public static void main(String[] args) {
    // Write a function that takes a filename as a parameter
    // The file contains an ended Tic-Tac-Toe match
    // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
    // Return "X", "O" or "Draw" based on the input file

    System.out.println(ticTacResult("assets/win-o.txt"));
    // Should print "O"

//    System.out.println(ticTacResult("assets/win-x.txt"));
    // Should print "X"

//    System.out.println(ticTacResult("assets/draw.txt"));
    // Should print "Draw"
  }

  private static String ticTacResult(String path) {

    List<String> results = getResults(path);
    List<String> positions = new ArrayList<>(results);

    positions.addAll(getColumns(results));

    

    System.out.println(positions);
    return "O";
  }

  private static List<String> getResults(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      System.out.println("File doest not exist: " + path);
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static List<String> getColumns(List<String> results) {
    List<String> columns = new ArrayList<>();
    for (int i = 0; i < results.size(); i++) {
      StringBuilder position = new StringBuilder();
      for (String pos : results) {
        position.append(pos, i, i + 1);
      }
      columns.add(position.toString());
    }
    return columns;
  }

}


