package potter;

import java.util.Map;

class Potter {

  private static final int BOOK_PRICE = 8;

  double getCost(Map<String, Integer> order) {
    double result = 0;
    int counter = 0;
    for (String inputB : order.keySet()) {
      result += order.get(inputB) * BOOK_PRICE;
      counter ++;
    }

    if(counter > 1){
      return result * 0.95;
    } else {
      return result;
    }
  }
}
