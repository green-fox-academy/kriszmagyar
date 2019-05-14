package wikipedia;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCounter {

  Map<String, Integer> countWords(String str) {
    return countWords(str, str.split(" ").length);
  }

  Map<String, Integer> countWords(String str, int mostCommon) {
    Stream<String> wordStream = Arrays.stream(
        str.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ")
    );
    return wordStream
        .collect(Collectors.groupingBy(
            String::toString, Collectors.summingInt(x -> 1)
        ))
        .entrySet().stream()
        .limit(mostCommon)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }

}
