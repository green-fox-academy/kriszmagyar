package fox;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FoxFinder {

  List<Fox> getWithColor(List<Fox> foxes, String color) {
    return foxes.stream()
        .filter(f -> f.getColor().equals(color))
        .collect(Collectors.toList());
  }

  List<Fox> getWithColorAndAge(List<Fox> foxes, String color, int age) {
    return foxes.stream()
        .filter(f -> f.getColor().equals(color))
        .filter(f -> f.getAge() < age)
        .collect(Collectors.toList());
  }

  Map<String, Integer> countByColor(List<Fox> foxes) {
    return foxes.stream()
        .collect(Collectors.groupingBy(
            Fox::getColor, Collectors.summingInt(x -> 1)
        ));
  }

}
