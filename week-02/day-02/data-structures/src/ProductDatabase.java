import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {

  public static void main(String[] args) {

    Map<String, Integer> products = initProducts();

    System.out.println("How much is the fish? " + products.get("fish"));
    System.out.println("What is the most expensive product? " + max(products));
    System.out.println("What is the average price? " + avg(products));
    System.out.println("How many products' price is below 300? " + below(products, 300));
    System.out.println("Is there anything we can buy for exactly 125? " + products.containsValue(125));
    System.out.println("What is the cheapest product? " + min(products));

  }

  private static String max(Map<String, Integer> products) {
    int maxPrice = 0;
    String productName = "";

    for (Map.Entry<String, Integer> product : products.entrySet()) {
      if (product.getValue() > maxPrice) {
        maxPrice = product.getValue();
        productName = product.getKey();
      }
    }

    return productName;
  }

  private static int sum(Map<String, Integer> products) {
    int result = 0;
    for (int val : products.values()) {
      result += val;
    }
    return result;
  }

  private static double avg(Map<String, Integer> products) {
    return (double) sum(products) / products.size();
  }

  private static int below(Map<String, Integer> products, int upper) {
    int numbOfBelow = 0;
    for (int value : products.values()) {
      if (value < upper) {
        numbOfBelow++;
      }
    }
    return numbOfBelow;
  }

  private static String min(Map<String, Integer> products) {
    int minPrice = Integer.MAX_VALUE;
    String productName = "";

    for (Map.Entry<String, Integer> product : products.entrySet()) {
      if (product.getValue() < minPrice) {
        minPrice = product.getValue();
        productName = product.getKey();
      }
    }

    return productName;
  }

  private static Map<String, Integer> initProducts() {
    Map<String, Integer> products = new HashMap<>();

    products.put("eggs",	200);
    products.put("milk",	200);
    products.put("fish",	400);
    products.put("apples",	150);
    products.put("bread",	50);
    products.put("chicken",	550);

  return products;
  }

}
