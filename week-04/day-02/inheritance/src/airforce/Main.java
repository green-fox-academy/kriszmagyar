package airforce;

public class Main {

  public static void main(String[] args) {

    Carrier carrier1 = new Carrier(15, 500);
    carrier1.add(new F16());
    carrier1.add(new F35());
    System.out.println(carrier1.getStatus());
    try {
      carrier1.fill();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(carrier1.getStatus());

    Carrier carrier2 = new Carrier(20, 50);

  }

}
