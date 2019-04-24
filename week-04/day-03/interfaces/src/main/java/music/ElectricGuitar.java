package main.java.music;

class ElectricGuitar extends StringedIntrument {

  ElectricGuitar() {
    this(6);
  }

  ElectricGuitar(int numbOfStrings) {
    super(numbOfStrings);
    setName("Electric Guitar");
  }

  @Override
  String sound() {
    return "Twang";
  }
}
