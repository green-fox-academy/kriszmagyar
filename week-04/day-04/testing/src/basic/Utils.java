package basic;

import java.util.List;

class Utils {

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
