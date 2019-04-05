import java.util.ArrayList;

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
        System.out.println(searchPalindrome(txt1)); // expects ["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]

        String txt2 = "";
        System.out.println(searchPalindrome(txt2)); // expects []

        String txt3 = "racecar";
        System.out.println(searchPalindrome(txt3)); // expects ["racecar", "aceca", "cec"]

        String txt4 = "";
        System.out.println(searchPalindrome(txt4)); // expects []

    }

    // A palindrome is a word, phrase, number, or other sequence of characters
    // which reads the same backward as forward, such as madam or racecar.

    private static String createPalindrome(String word) {

        if (isPalindrome(word)) {
            return word;
        }

        String reverse = new StringBuilder(word).reverse().toString();
        return word.concat(reverse);
    }

    private static boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return reverse.equals(word);
    }

    private static ArrayList<String> searchPalindrome(String txt) {

        int minLength = 3;
        int txtLength = txt.length();
        ArrayList<String> palindromes = new ArrayList<>();

        // Iterate over the length of words
        for (int i = txtLength; i >= minLength; i--) {

            // Set the starting position of the substrings
            for (int j = 0; j <= txtLength - i; j++) {

                String sub = txt.substring(j, i + j);

                if (isPalindrome(sub)) {
                    palindromes.add(sub);
                }

            }
        }

        return palindromes;
    }

}
