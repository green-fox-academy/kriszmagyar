package utils;

import java.util.List;
import java.util.stream.Collectors;

class IntUtils {

  static List<Integer> getEven(List<Integer> list) {
    return list.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
  }

}
