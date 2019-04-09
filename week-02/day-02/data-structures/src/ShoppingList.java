import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {

  public static void main(String[] args) {
    List<String> shoppingList = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));
    System.out.println("Do we have milk? " + shoppingList.contains("milk"));
    System.out.println("Do we have bananas? " + shoppingList.contains("banana"));
  }

}
