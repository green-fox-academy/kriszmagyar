package garden;

public class Main {

  public static void main(String[] args) {

    Garden garden = new Garden();
    garden.add(new Flower("yellow"));
    garden.add(new Flower("blue"));
    garden.add(new Tree("purple"));
    garden.add(new Tree("orange"));

    garden.printState();
    garden.water(40);
    garden.printState();
    garden.water(70);
    garden.printState();

  }

}
