package main.java.music;

abstract class StringedIntrument extends Instrument {

  private int numbOfStrings;

  abstract String sound();

  public StringedIntrument(int numbOfStrings) {
    this.numbOfStrings = numbOfStrings;
  }
}
