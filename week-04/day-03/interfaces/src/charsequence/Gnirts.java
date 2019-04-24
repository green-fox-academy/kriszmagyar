package charsequence;

public class Gnirts implements CharSequence {

  private String reverse;

  public Gnirts(String reverse) {
    this.reverse = reverse;
  }

  @Override
  public int length() {
    return this.reverse.length();
  }

  @Override
  public char charAt(int index) {
    return this.reverse.charAt(length() - index - 1);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return null;
  }
}
