package main.java.music;

class ElectricGuitar extends StringedIntrument {

  ElectricGuitar() {
    this(6);
  }

  ElectricGuitar(int numbOfStrings) {
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
