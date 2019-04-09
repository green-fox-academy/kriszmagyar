import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntro {

  public static void main(String[] args) {

    List<String> names = new ArrayList<>();
    System.out.println(names.size());

    names.add("William");
    System.out.println(names.isEmpty());

    names.add("John");
    names.add("Amanda");
    System.out.println(names.size());
    System.out.println(names.get(2));

    for (String name : names) {
      System.out.println(name);
    }

    for (int i = 0; i < names.size(); i++) {
      System.out.println((i + 1) + ". " + names.get(i));
    }

    names.remove(1);

    for (int i = names.size() - 1; i >= 0; i--) {
      System.out.println(names.get(i));
    }

    names.clear();
    System.out.println(names);

    System.out.println("\n-------------------------------------\nArray Lists\n-------------------------------------");
    List<String> listA = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lychee"));
    List<String> listB = new ArrayList<>(listA);

    System.out.println(listA.contains("Durian"));
    listA.remove("Durian");
    listA.add(3, "Kiwifruit");
    System.out.println(listA.size() == listB.size());

    listA.indexOf("Avocado");
    listB.indexOf("Durian");

    listB.addAll(Arrays.asList("Passion Fruit", "Pummelo"));
    System.out.println(listA.get(2));

    System.out.println("A: " + listA);
    System.out.println("B: " + listB);
  }

}
