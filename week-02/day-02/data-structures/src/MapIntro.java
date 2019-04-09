import java.util.HashMap;
import java.util.Map;

public class MapIntro {

  public static void main(String[] args) {

    Map<Integer, Character> map = new HashMap<>();
    System.out.println(map.isEmpty());

    map.put(97, 'a');
    map.put(98, 'b');
    map.put(99, 'c');
    map.put(65, 'A');
    map.put(66, 'B');
    map.put(67, 'C');

    System.out.println(map.keySet());
    System.out.println(map.values());

    map.put(68, 'D');

    System.out.println("size: " + map.size());
    System.out.println(map.get(99));

    map.remove(97);
    System.out.println(map.containsKey(100));
    map.clear();

  }

}
