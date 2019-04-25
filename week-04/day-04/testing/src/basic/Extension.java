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
    return Arrays.asList('a', 'A', 'u', 'U', 'o', 'O', 'e', 'E', 'i', 'I').contains(c);
  }

  String translate(String hungarian) {
    StringBuilder teve = new StringBuilder();
    for (char c : hungarian.toCharArray()) {
      if (isVowel(c)) {
        teve.append(c).append('v').append(c);
      } else {
        teve.append(c);
      }
    }
    return teve.toString();
  }
}