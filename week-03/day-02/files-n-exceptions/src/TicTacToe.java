import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

  public static void main(String[] args) {
    // Write a function that takes a filename as a parameter
    // The file contains an ended Tic-Tac-Toe match
    // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
    // Return "X", "O" or "Draw" based on the input file

    System.out.println(ticTacResult("assets/win-o.txt"));
    // Should print "O"

    System.out.println(ticTacResult("assets/win-x.txt"));
    // Should print "X"

    System.out.println(ticTacResult("assets/draw.txt"));
    // Should print "Draw"
  }

  private static String ticTacResult(String path) {
    return getWinner(
        getPositions(
            getResults(path)
        )
    );
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

  private static List<String> getPositions(List<String> results) {
    List<String> positions = new ArrayList<>(results);
    positions.addAll(getColumns(results));
    positions.addAll(getDiagonals(results));
    return positions;
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

  private static List<String> getDiagonals(List<String> results) {
    List<String> diagonals = new ArrayList<>();
    StringBuilder normalDiagonal = new StringBuilder();
    StringBuilder revertDiagonal = new StringBuilder();

    for (int i = 0; i < results.size(); i++) {
      normalDiagonal.append(results.get(i), i, i + 1);
      revertDiagonal.append(results.get(i), results.size() - i - 1, results.size() - i );
    }

    diagonals.add(normalDiagonal.toString());
    diagonals.add(revertDiagonal.toString());
    return diagonals;
  }

  private static String getWinner(List<String> positions) {
    for (String pos : positions) {
      if (!pos.contains("O")) {
        return "X";
      }
      if (!pos.contains("X")) {
        return "O";
      }
    }
    return "Draw";
  }

}


