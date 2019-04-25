package basic;

import java.util.Arrays;
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

  static boolean isAnagram(String str1, String str2) {
    return toAlphabeticLowercase(str1)
        .equals(toAlphabeticLowercase(str2));
  }

  private static String toAlphabeticLowercase(String str) {
    char[] alphabetic = str.toLowerCase().toCharArray();
    Arrays.sort(alphabetic);
    return new String(alphabetic);
  }

}
