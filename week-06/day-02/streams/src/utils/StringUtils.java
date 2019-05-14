package utils;

import java.util.List;
import java.util.stream.Collectors;

class StringUtils {

  static List<Character> getUppercase(String str) {
    return str.chars()
        .mapToObj(i -> (char)i)
        .filter(Character::isUpperCase)
        .collect(Collectors.toList());
  }

  static List<String> getStartsWith(List<String> list, String start) {
    return list.stream()
        .filter(s -> s.startsWith(start))
        .collect(Collectors.toList());
  }

}
