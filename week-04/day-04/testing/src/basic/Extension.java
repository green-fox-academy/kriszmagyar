package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Extension {
  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > c){
      return b;
    } else {
      return c;
    }
  }

  double median(List<Integer> pool) {
    List<Integer> sortedPool = new ArrayList<>(pool);
    Collections.sort(sortedPool);

    if (sortedPool.size() % 2 == 0) {
      int halfSize = sortedPool.size() / 2;
      return ((double) sortedPool.get(halfSize - 1) + sortedPool.get(halfSize)) / 2;
    }

    return sortedPool.get((sortedPool.size() - 1) / 2);
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    int length = teve.length();
    for (int i = 0; i < length; i++) {
      char c = teve.charAt(i);
      if (isVowel(c)) {
        teve = String.join(c + "v" + c, teve.split(""+c));
        i+=2;
        length+=2;
      }
    }
    return teve;
  }
}