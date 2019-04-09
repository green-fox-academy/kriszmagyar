public class Anagram {

  public static void main(String[] args) {

    // An anagram is direct word switch or word play,
    // the result of rearranging the letters of a word
    // or phrase to produce a new word or phrase, using
    // all the original letters exactly once; for example,
    // the word anagram can be rearranged into nag-a-ram.

    System.out.println(isAnagram("Dog", "gOd")); //expects true
    System.out.println(isAnagram("green", "fox")); //expects false

  }

  private static boolean isAnagram(String str1, String str2) {

    for (int i = 0; i < str1.length(); i++) {
      if (numbOfAppearance(str1.charAt(i), str1) != numbOfAppearance(str2.charAt(2), str2)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Returns how many times a letter appears in a text
   */
  private static int numbOfAppearance(char letter, String txt) {
    return txt.length() - txt.toLowerCase().replaceAll(String.valueOf(letter).toLowerCase(), "").length();
  }

}
