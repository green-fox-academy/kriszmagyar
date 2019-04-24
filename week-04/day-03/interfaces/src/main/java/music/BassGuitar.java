package main.java.music;

class BassGuitar extends StringedIntrument {

  BassGuitar() {
    this(4);
  }

  BassGuitar(int numbOfStrings) {
    super(numbOfStrings);
    setName("Bass Guitar");
  }

  @Override
  String sound() {
    return "Duum-duum-duum";
  }
}
