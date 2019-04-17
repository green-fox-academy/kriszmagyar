import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
  private List<Sharpie> sharpies;

  public SharpieSet() {
    this.sharpies = new ArrayList<>();
  }

  void add(Sharpie sharpie) {
    this.sharpies.add(sharpie);
  }

  int countUsable() {
    int counter = 0;
    for (Sharpie sharpie : sharpies) {
      if (sharpie.isUsable()) {
        counter++;
      }
    }
    return counter;
  }

  void removeTrash() {
    for (Sharpie sharpie : sharpies) {
      if (!sharpie.isUsable()) {
        sharpies.remove(sharpie);
      }
    }
  }
}
