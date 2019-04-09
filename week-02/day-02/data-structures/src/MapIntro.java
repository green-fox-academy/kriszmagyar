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

    System.out.println("\n-------------\n");

    Map<String, String> books = new HashMap<>();
    books.put("978-1-60309-452-8",	"A Letter to Jo");
    books.put("978-1-60309-459-7",	"Lupus");
    books.put("978-1-60309-444-3",	"Red Panda and Moon Bear");
    books.put("978-1-60309-461-0",	"The Lab");

    print(books);

    books.remove("978-1-60309-444-3");
    books.values().remove("The Lab");
    print(books);

    books.put("978-1-60309-450-4",	"They Called Us Enemy");
    books.put("978-1-60309-453-5",	"Why Did We Trust Him?");
    System.out.println(books.containsKey("478-0-61159-424-8"));
    System.out.println(books.get("978-1-60309-453-5"));

  }

  private static void print(Map<String, String> map) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getValue() + " (" + entry.getKey() + ")");
    }
    System.out.println("-------------");
  }

}
