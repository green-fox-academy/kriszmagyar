package utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  static String concatenate(String str, List<Character> chars) {
    return Stream.concat(
        str.chars().mapToObj(i -> (char) i),
        chars.stream()
    )
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static Map<Character, Integer> countLetters(String str) {
    return str.chars()
        .mapToObj(i -> (char) i)
        .collect(Collectors.toMap(c -> c, c -> (int) c));
  }

}
