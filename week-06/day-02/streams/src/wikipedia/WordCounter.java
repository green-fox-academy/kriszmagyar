package wikipedia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCounter {

  Map<String, Integer> countWordsFromFile(String filename) {
    List<String> rows = getData(filename);
    String data = String.join(", ", rows);
    Map<String, Integer> map = countWords(data, 100);
    System.out.println(map);
    return map;
  }

  Map<String, Integer> countWords(String str) {
    return countWords(str, str.split(" ").length);
  }

  Map<String, Integer> countWords(String str, int mostCommon) {
    return Arrays.stream(format(str))
        .filter(s -> !s.isEmpty())
        .collect(Collectors.groupingBy(String::toString, Collectors.summingInt(x -> 1)))
        .entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .limit(mostCommon)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

  private String[] format(String str) {
    return str.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
  }

  private List<String> getData(String filename) {
    try {
      return Files.readAllLines(Paths.get(filename));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

}
