public class Palindrome {
    public static void main(String[] args) {

        String str1 = "";
        System.out.println(createPalindrome(str1)); // expects ""

        String str2 = "greenfox";
        System.out.println(createPalindrome(str2)); // expects "greenfoxxofneerg"

        String str3 = "123";
        System.out.println(createPalindrome(str3)); // expects "123321"

        String str4 = "racecar";
        System.out.println(createPalindrome(str4)); // expects "racecar"

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

}
