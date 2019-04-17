import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    PostIt idea = new PostIt("orange", "Idea 1", "blue");
    PostIt awesome = new PostIt("pink", "Awesome", "black");
    PostIt superb = new PostIt("yellow", "Superb", "green");

    BlogPost post1 = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04");
    BlogPost post2 = new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10");
    BlogPost post3 = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28");

    Animal tiger = new Animal();
    tiger.eat();
    tiger.drink();
    tiger.play();
    System.out.println(tiger.getHunger());
    System.out.println(tiger.getThirst());

    Sharpie sharpie = new Sharpie("black", 50.0);
    sharpie.use();
    System.out.println(sharpie.getInkAmount());
    SharpieSet sharpieSet = new SharpieSet();
    sharpieSet.add(sharpie);

    List<Pokemon> pokemonOfAsh = initializePokemons();
    Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");
    System.out.println("I choose you, " + choosePokemon(pokemonOfAsh, wildPokemon));

    Fleet fleet = new Fleet();
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    fleet.add(new Thing("Get milk"));
    fleet.add(new Thing("Remove the obstacles"));
    fleet.add(new Thing("Stand up"));
    fleet.add(new Thing("Eat lunch"));

    fleet.complete("Stand up");
    fleet.complete("Eat lunch");

    System.out.println(fleet);

    Student student = new Student();
    Teacher teacher = new Teacher();
    student.question(teacher);
    teacher.teach(student);

    Station station = new Station(2500);
    Car car = new Car();
    station.refill(car);

  }

  private static String choosePokemon(List<Pokemon> pokemons, Pokemon wildPokemon) {
    for (Pokemon pokemon : pokemons) {
      if (pokemon.isEffectiveAgainst(wildPokemon)) {
        return pokemon.name;
      }
    }
    return "";
  }

  private static List<Pokemon> initializePokemons() {
    List<Pokemon> pokemon = new ArrayList<>();

    pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
    pokemon.add(new Pokemon("Pikatchu", "electric", "water"));
    pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
    pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
    pokemon.add(new Pokemon("Kingler", "water", "fire"));

    return pokemon;
  }

}
