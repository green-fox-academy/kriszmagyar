package reservations;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Reservation> reservations = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      reservations.add(new Reservation());
    }

    for (Reservation r : reservations) {
      System.out.println(r);
    }

  }

}
