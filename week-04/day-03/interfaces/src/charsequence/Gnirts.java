package charsequence;

public class Gnirts implements CharSequence {

  private String reverse;

  Gnirts(String reverse) {
    this.reverse = reverse;
  }

  @Override
  public int length() {
    return this.reverse.length();
  }

  @Override
  public char charAt(int index) {
    try {
      return this.reverse.charAt(length() - index - 1);
    } catch (StringIndexOutOfBoundsException e) {
      return '\u0000'; // empty char
    }
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return new StringBuilder(this.reverse).reverse().substring(start, end);
  }
}
