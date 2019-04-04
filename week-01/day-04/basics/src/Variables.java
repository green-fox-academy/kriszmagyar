public class Variables {
    public static void main(String[] args) {

        // Favorite number
        int favoriteNumber = 23;
        System.out.println("\"My favorite number is: " + favoriteNumber + "\"");

        // Swap
        int a = 123;
        int b = 526;
        int tmp;

        tmp = a;
        a = b;
        b = tmp;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        // BMI
        double massInKg  = 81.2;
        double heightInM = 1.78;

        double bmi = massInKg / Math.pow(heightInM, 2);
        System.out.println("BMI: " + bmi);

    }
}
