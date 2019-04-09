import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingList {

  public static void main(String[] args) {
    List<String> shoppingList = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));
    System.out.println("Do we have milk? " + shoppingList.contains("milk"));
    System.out.println("Do we have bananas? " + shoppingList.contains("banana"));
    System.out.println("-----------------------");

    Map<String, Double> products = productsInit();
    Map<String, Integer> bobShoppingList = bobShoppingListInit();
    Map<String, Integer> aliceShoppingList = aliceShoppingListInit();

    System.out.println("How much does Bob pay? " + getTotalCost(bobShoppingList, products));
    System.out.println("How much does Alice pay? " + getTotalCost(aliceShoppingList, products));
    System.out.println("Who buys more rice? " + getWhoBuysMore(bobShoppingList, aliceShoppingList, "rice"));
    System.out.println("Who buys more potato? " + getWhoBuysMore(bobShoppingList, aliceShoppingList, "potato"));
    System.out.println("Who buys more different products? " + getWhoBuysMoreDifferent(bobShoppingList, aliceShoppingList));
    System.out.println("Who buys more products? (piece) " + getWhoBuysMore(bobShoppingList, aliceShoppingList));

  }

  private static double getTotalCost(Map<String, Integer> shoppingList, Map<String, Double> products) {
    double totalCost = 0;
    for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
      int amount = entry.getValue();
      double price = products.get(entry.getKey());
      totalCost += amount * price;
    }
    return totalCost;
  }

  private static String getWhoBuysMore(Map<String, Integer> bobShoppingList, Map<String, Integer> aliceShoppingList) {
    int diff = getAmount(bobShoppingList) - getAmount(aliceShoppingList);
    return getName(diff);
  }

  private static String getWhoBuysMore(Map<String, Integer> bobShoppingList, Map<String, Integer> aliceShoppingList, String product) {
    int diff = getAmount(bobShoppingList, product) - getAmount(aliceShoppingList, product);
    return getName(diff);
  }

  private static int getAmount(Map<String, Integer> shoppingList) {
    int totalAmount = 0;
    for (int amount : shoppingList.values()) {
      totalAmount += amount;
    }
    return totalAmount;
  }

  private static int getAmount(Map<String, Integer> shoppingList, String key) {
    for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
      if (key.toLowerCase().equals(entry.getKey().toLowerCase())) {
        return entry.getValue();
      }
    }
    return 0;
  }

  private static String getWhoBuysMoreDifferent(Map<String, Integer> bobShoppingList, Map<String, Integer> aliceShoppingList) {
    int diff = getNumbOfDiffProductsBought(bobShoppingList) - getNumbOfDiffProductsBought(aliceShoppingList);
    return getName(diff);
  }

  private static int getNumbOfDiffProductsBought(Map<String, Integer> shoppingList) {
    int numbOfProducts = 0;
    for (int amount : shoppingList.values()) {
      if (amount > 0) {
        numbOfProducts++;
      }
    }
    return numbOfProducts;
  }

  private static String getName(int diff) {
    if (diff > 0) {
      return "Bob";
    } else if (diff < 0) {
      return "Alice";
    } else {
      return "Same amount";
    }
  }

  private static Map<String, Double> productsInit() {
    Map<String, Double> products = new HashMap<>();

    products.put("Milk",	1.07);
    products.put("Rice",	1.59);
    products.put("Eggs",	3.14);
    products.put("Cheese",	12.60);
    products.put("Chicken Breasts",	9.40);
    products.put("Apples",	2.31);
    products.put("Tomato",	2.58);
    products.put("Potato",	1.75);
    products.put("Onion",	1.10);

    return products;
  }

  private static Map<String, Integer> bobShoppingListInit() {
    Map<String, Integer> map = new HashMap<>();

    map.put("Milk",	1);
    map.put("Rice",	2);
    map.put("Eggs",	2);
    map.put("Cheese",	1);
    map.put("Chicken Breasts",	4);
    map.put("Apples",	1);
    map.put("Tomato",	2);
    map.put("Potato",	1);

    return map;
  }

  private static Map<String, Integer> aliceShoppingListInit() {
    Map<String, Integer> map = new HashMap<>();

    map.put("Rice",	1);
    map.put("Eggs",	5);
    map.put("Chicken Breasts",	2);
    map.put("Apples",	1);
    map.put("Tomato",	10);

    return map;
  }

}
