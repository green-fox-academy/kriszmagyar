import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {

        String a1 = "Dog";
        String b1 = "god";
        System.out.println(isAnagram(a1, b1)); // expects true

        String a2 = "green";
        String b2 = "fox";
        System.out.println(isAnagram(a2, b2)); // expects false

    }

    // An anagram is direct word switch or word play,
    // the result of rearranging the letters of a word or phrase
    // to produce a new word or phrase, using all the original letters exactly once;
    // for example, the word anagram can be rearranged into nag-a-ram.

    private static boolean isAnagram(String a, String b) {

        char[] arrFromA = a.toLowerCase().toCharArray();
        char[] arrFromB = b.toLowerCase().toCharArray();

        Arrays.sort(arrFromA);
        Arrays.sort(arrFromB);

        return Arrays.equals(arrFromA, arrFromB);
    }

}
