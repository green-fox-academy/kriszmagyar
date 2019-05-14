package utils;

import java.util.List;
import java.util.stream.Collectors;

class IntUtils {

  static List<Integer> getEven(List<Integer> list) {
    return list.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
  }

  static List<Double> getSquared(List<Integer> list) {
    return list.stream()
        .map(Integer::doubleValue)
        .map(Math::abs)
        .map(Math::sqrt)
        .collect(Collectors.toList());
  }

}
