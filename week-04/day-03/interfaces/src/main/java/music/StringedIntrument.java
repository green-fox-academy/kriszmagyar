package main.java.music;

abstract class StringedIntrument extends Instrument {

  private int numbOfStrings;

  StringedIntrument(int numbOfStrings) {
    this.numbOfStrings = numbOfStrings;
  }

  abstract String sound();

  @Override
  void play() {
    System.out.println(getName() + ", a " + this.numbOfStrings
        + "-stringed instrument that goes " + sound());
  }
}
