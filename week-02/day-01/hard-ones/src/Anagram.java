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

    char[] charArr1 = str1.toLowerCase().toCharArray();
    char[] charArr2 = str2.toLowerCase().toCharArray();

    for (char letter : charArr1) {
      if (numbOfAppearance(letter, charArr1) != numbOfAppearance(letter, charArr2)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Returns how many times a letter appears in a text
   */
  private static int numbOfAppearance(char letter, char[] arr) {
    String txt = new String(arr);
    return txt.length() - txt.replaceAll(String.valueOf(letter), "").length();
  }

}
