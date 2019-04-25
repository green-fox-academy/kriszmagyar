package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  static Map<Character, Integer> countLetters(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray()) {
      int current = map.get(c) == null ? 0 : map.get(c);
      map.put(c, current + 1);
    }
    return map;
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
