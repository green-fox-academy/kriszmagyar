package basic;

class Domino implements Comparable<Domino> {
  private final int left;
  private final int right;

  Domino(int left, int right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "[" + this.left + ", " + this.right + "]";
  }

  @Override
  public int compareTo(Domino d) {
    return toString().compareTo(d.toString());
  }
}
