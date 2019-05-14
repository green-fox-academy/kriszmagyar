package fox;

import java.util.List;
import java.util.stream.Collectors;

class FoxFinder {

  List<Fox> getWithColor(List<Fox> foxes, String color) {
    return foxes.stream()
        .filter(f -> f.getColor().equals(color))
        .collect(Collectors.toList());
  }

}
