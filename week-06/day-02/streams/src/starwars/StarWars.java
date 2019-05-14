package starwars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class StarWars {

  private List<SWCharacter> listOfChars;

  StarWars() {
    List<String> rows = getData("src/starwars/swcharacters.csv");
    listOfChars = populateList(rows);
  }

  String getNameOfHeaviest() {
    return listOfChars.stream()
        .filter(c -> c.getMass() != -1)
        .max(Comparator.comparingInt(SWCharacter::getMass))
        .orElseThrow(NoSuchElementException::new)
        .getName();
  }

  private List<SWCharacter> populateList(List<String> rows) {
    return rows.stream()
        .skip(1)
        .map(row -> new SWCharacter(row.split(";")))
        .collect(Collectors.toList());
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
