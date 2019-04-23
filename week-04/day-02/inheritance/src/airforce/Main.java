package airforce;

public class Main {

  public static void main(String[] args) {

    Carrier carrier1 = new Carrier(300, 500);
    carrier1.add(new F16());
    carrier1.add(new F35());
    fill(carrier1);

    Carrier carrier2 = new Carrier(20, 900);
    carrier1.fight(carrier2);

    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());

  }

  private static void fill(Carrier carrier) {
    try {
      carrier.fill();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
