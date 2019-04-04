public class Variables {
    public static void main(String[] args) {

        // Favorite number
        int favoriteNumber = 23;
        System.out.println("\"My favorite number is: " + favoriteNumber + "\"");


        // Swap
        int x = 123;
        int y = 526;
        int tmp;

        tmp = x;
        x = y;
        y = tmp;

        System.out.println("x: " + x);
        System.out.println("y: " + y);


        // BMI
        double massInKg  = 81.2;
        double heightInM = 1.78;

        double bmi = massInKg / Math.pow(heightInM, 2);
        System.out.println("BMI: " + bmi);


        // Define basic info
        String  name          = "Krisz";
        int     age           = 26;
        double  heightInMeter = 1.85;
        boolean isMarried     = false;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + heightInMeter + "m");
        System.out.println("Married: " + isMarried);

    }
}