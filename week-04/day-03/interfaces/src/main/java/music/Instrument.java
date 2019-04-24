package main.java.music;

abstract class Instrument {

  private String name;

  abstract void play();

  String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

}
