package basic;

class Thing implements Comparable<Thing> {

  private String desc;
  private boolean completed;

  Thing(String desc) {
    this.desc = desc;
    this.completed = false;
  }

  void complete() {
    this.completed = true;
  }

  String getDesc() {
    return this.desc;
  }

  @Override
  public String toString() {
    return (this.completed ? "[x] " : "[ ] ") + this.desc;
  }

  @Override
  public int compareTo(Thing t) {
    return 0;
  }
}
