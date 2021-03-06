import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiveTrees {

  public static void main(String[] args) {
    List<Map<String, Object>> trees = new ArrayList<>();
    trees.add(initTree("maples", "green", 25, "male"));
    trees.add(initTree("pine", "green", 40, "male"));
    trees.add(initTree("spruce", "white", 15, "female"));
    trees.add(initTree("tulip", "red", 5, "male"));
    trees.add(initTree("oak", "yellow", 27, "male"));
    print(trees);

    List<Tree> trees2 = new ArrayList<>();
    trees2.add(new Tree("maples", "green", "male", 25));
    trees2.add(new Tree("pine", "green", "male", 40));
    trees2.add(new Tree("spruce", "white", "female", 15));
    trees2.add(new Tree("tulip", "red", "male", 5));
    trees2.add(new Tree("oak", "yellow", "male", 27));
  }

  private static Map<String, Object> initTree(String type, String color, int age, String sex) {
    Map<String, Object> tree = new HashMap<>();
    tree.put("type", type);
    tree.put("color", color);
    tree.put("age", age);
    tree.put("sex", sex);
    return tree;
  }

  private static void print(List<Map<String, Object>> trees) {
    for (Map<String, Object> map : trees) {
      System.out.println(map);
    }
  }

}
