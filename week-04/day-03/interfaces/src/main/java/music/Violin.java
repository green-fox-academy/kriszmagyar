package main.java.music;

class Violin extends StringedIntrument {

  Violin() {
    this(4);
  }

  Violin(int numbOfStrings) {
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
