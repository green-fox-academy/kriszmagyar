import java.util.ArrayList;

public class Palindrome {
    public static void main(String[] args) {

        // Test cases for createPalindrome
        System.out.println(createPalindrome(""));          // expects ""
        System.out.println(createPalindrome("greenfox"));  // expects "greenfoxxofneerg"
        System.out.println(createPalindrome("123"));       // expects "123321"
        System.out.println(createPalindrome("racecar"));   // expects "racecar"

        // Test cases for search palindrome
        System.out.println(searchPalindrome("dog goat dad duck doodle never"));  // expects ["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]
        System.out.println(searchPalindrome(""));                                // expects []
        System.out.println(searchPalindrome("racecar"));                         // expects ["racecar", "aceca", "cec"]
        System.out.println(searchPalindrome(""));                                // expects []

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
        return new StringBuilder(word).reverse().toString();
    }

    private static ArrayList<String> searchPalindrome(String txt) {

        int minLength = 3;
        ArrayList<String> palindromes = new ArrayList<>();

        // Iterate over the length of words
        for (int i = txt.length(); i >= minLength; i--) {

            // Set the starting position of the substrings
            for (int j = 0; j <= txt.length() - i; j++) {

                String sub = txt.substring(j, i + j);
                if (isPalindrome(sub)) {
                    palindromes.add(sub);
                }
            }
        }
        return palindromes;
    }

}
