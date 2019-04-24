package main.java.music;

class BassGuitar extends StringedIntrument {

  public BassGuitar() {
    this(4);
  }

  BassGuitar(int numbOfStrings) {
    super(numbOfStrings);
  }

  @Override
  String sound() {
    return null;
  }

  @Override
  void play() {

  }
}
