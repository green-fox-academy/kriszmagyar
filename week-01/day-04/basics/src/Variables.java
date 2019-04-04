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


        // Variable mutation
        int a = 3;
        a += 10;
        System.out.println("a: " + a);

        int b = 100;
        b -= 100;
        System.out.println("b: " + b);

        int c = 44;
        c *= 2;
        System.out.println("c: " + c);

        int d = 125;
        d /= 5;
        System.out.println("d: " + d);

        int e = 8;
        e = e * e * e;
        System.out.println("e: " + e);

        int f1 = 123;
        int f2 = 345;
        System.out.println("f: " + (f1 > f2));

        int g1 = 350;
        int g2 = 200;
        System.out.println("g: " + ((double) g2 > g1));

        int h = 135798745;
        System.out.println("h: " + (h % 11 == 0));

        int i1 = 10;
        int i2 = 3;
        System.out.println("i: " + ((i1 > i2 * i2) && (i1 < i2 * i2 * i2)));

        int j = 1521;
        System.out.println("j: " + ((j % 3 == 0) || (j % 5 == 0)));

    }
}