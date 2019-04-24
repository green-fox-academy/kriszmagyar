package main.java.music;

class Violin extends StringedIntrument {

  Violin() {
    this(4);
  }

  Violin(int numbOfStrings) {
    super(numbOfStrings);
    setName("Violin");
  }

  @Override
  String sound() {
    return "Screech";
  }
}
