public class Isogram {

  public static void main(String[] args) {

    // An isogram is a word that has no repeating letters,
    // consecutive or non-consecutive. Implement a function
    // that determines whether a string that contains only
    // letters is an isogram. Assume the empty string
    // is an isogram. Ignore letter case.

    System.out.println(isIsogram("Dermatoglyphics")); // expects true
    System.out.println(isIsogram("moose")); // expects false
    System.out.println(isIsogram("moOse")); // expects false
    System.out.println(isIsogram("aba")); // expects false

  }

  private static boolean isIsogram(String str) {
    for (int i = 0; i < str.length(); i++) {
      char letter = str.toLowerCase().toCharArray()[i];
      if (numbOfApparences(letter, str) > 1) {
        return false;
      }
    }

    return true;
  }

  private static int numbOfApparences(char letter, String str) {
    int counter = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.toLowerCase().toCharArray()[i] == letter) {
        counter++;
      }
    }

    return counter;
  }

}
