package main.java.music;

abstract class Instrument {

  private String name;

  abstract void play();

  void setName(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

}
