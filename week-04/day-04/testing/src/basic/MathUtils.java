package basic;

import java.util.List;

class MathUtils {

  static int sum(List<Integer> list) {
    if (list == null) {
      return 0;
    }

    int result = 0;
    for (int n : list) {
      result += n;
    }
    return result;
  }

}
