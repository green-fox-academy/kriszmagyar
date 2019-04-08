import java.util.Arrays;

public class Palindrome {
  public static void main(String[] args) {

    // Test cases for createPalindrome

    String str1 = "";
    System.out.println(createPalindrome(str1)); // expects ""

    String str2 = "greenfox";
    System.out.println(createPalindrome(str2)); // expects "greenfoxxofneerg"

    String str3 = "123";
    System.out.println(createPalindrome(str3)); // expects "123321"

    String str4 = "racecar";
    System.out.println(createPalindrome(str4)); // expects "racecar"


    // Test cases for search palindrome

    String txt1 = "dog goat dad duck doodle never";
    System.out.println(Arrays.toString(searchPalindrome(txt1))); // expects ["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]

    String txt2 = "";
    System.out.println(Arrays.toString(searchPalindrome(txt2))); // expects []

    String txt3 = "racecar";
    System.out.println(Arrays.toString(searchPalindrome(txt3))); // expects ["racecar", "aceca", "cec"]

    String txt4 = "";
    System.out.println(Arrays.toString(searchPalindrome(txt4))); // expects []

  }

  // A palindrome is a word, phrase, number, or other sequence of characters
  // which reads the same backward as forward, such as madam or racecar.

  private static String createPalindrome(String word) {

    if (isPalindrome(word)) {
      return word;
    }

    return word.concat(reverse(word));
  }

  private static boolean isPalindrome(String word) {
    return word.equals(reverse(word));
  }

  private static String reverse(String word) {
    char[] results = new char[word.length()];

    for (int i = 0; i < results.length; i++) {
      results[i] = word.toCharArray()[word.length() - 1 - i];
    }

    return String.valueOf(results);
  }

  private static String[] searchPalindrome(String txt) {

    int minLength = 3;
    int txtLength = txt.length();
    int numbOfPalindromes = 0;
    String[] palindromes = new String[txtLength];

    // Iterate over the length of words
    for (int i = txtLength; i >= minLength; i--) {

      // Set the starting position of the substrings
      for (int j = 0; j <= txtLength - i; j++) {

        String sub = txt.substring(j, i + j);

        if (isPalindrome(sub)) {
          palindromes[numbOfPalindromes++] = sub;
        }

      }
    }

    return Arrays.copyOf(palindromes, numbOfPalindromes);
  }

}