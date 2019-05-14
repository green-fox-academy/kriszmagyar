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

}
