import java.util.ArrayList;

/**
 * Created by aze on 2017.03.29..
 */
public class Fleet {
  private ArrayList<Thing> things;

  public Fleet() {
    things = new ArrayList<>();
  }

  public void add(Thing thing) {
    things.add(thing);
  }

  public void complete(String name) {
    for (Thing thing : things) {
      if (thing.getName().equals(name)) {
        thing.complete();
      }
    }
  }

  @Override
  public String toString() {
    String result = "";
    for(int i = 0; i < things.size(); i++) {
      result += (i+1) + ". " + things.get(i) + "\n";
    }
    return result;
  }
}