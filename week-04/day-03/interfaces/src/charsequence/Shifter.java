package charsequence;

public class Shifter implements CharSequence {

  private String str;
  private int shift;

  Shifter(String str, int shift) {
    this.str = str;
    this.shift = shift;
  }

  @Override
  public int length() {
    return this.str.length();
  }

  @Override
  public char charAt(int index) {
    try {
      return this.str.charAt(index + this.shift);
    } catch (StringIndexOutOfBoundsException e) {
      return '\u0000'; // empty char
    }
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    start = Math.max(start + this.shift, 0);
    end = Math.min(end + this.shift, length() - 1);
    return this.str.substring(start, end);
  }
}
