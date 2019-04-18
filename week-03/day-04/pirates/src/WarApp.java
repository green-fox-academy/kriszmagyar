public class WarApp {

  public static void main(String[] args) {

    Armada armada1 = new Armada();
    Armada armada2 = new Armada();

    boolean isFirstArmadaWinning = armada1.war(armada2);
    System.out.println(isFirstArmadaWinning);
  }

}
