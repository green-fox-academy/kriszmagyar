package main.java.music;

abstract class StringedIntrument extends Instrument {

  private int numbOfStrings;

  abstract String sound();

  StringedIntrument(int numbOfStrings) {
    this.numbOfStrings = numbOfStrings;
  }

  @Override
  void play() {
    System.out.println(getName() + ", a " + this.numbOfStrings
        + "-stringed instrument that goes " + sound());
  }
}
