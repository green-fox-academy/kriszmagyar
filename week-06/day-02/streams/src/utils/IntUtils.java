package utils;

import java.util.List;
import java.util.stream.Collectors;

class IntUtils {

  static List<Integer> getEven(List<Integer> list) {
    return list.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
  }

  static List<Double> getSqrt(List<Integer> list) {
    return list.stream()
        .map(Integer::doubleValue)
        .map(Math::abs)
        .map(Math::sqrt)
        .collect(Collectors.toList());
  }

  static List<Integer> getHighSquares(List<Integer> list, int min) {
    return list.stream()
        .map(n -> n * n)
        .filter(n -> n > min)
        .collect(Collectors.toList());
  }

  static double getAvgOfOdd(List<Integer> list) {
    return list.stream()
        .filter(IntUtils::isOdd)
        .mapToDouble(Integer::doubleValue)
        .average()
        .orElse(0);
  }

  private static boolean isOdd(int n) {
    return n % 2 == 1 || n % 2 == -1;
  }

}
