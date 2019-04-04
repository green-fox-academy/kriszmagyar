public class Loops {
    public static void main(String[] args) {

        // Note: Some tasks require user inputs, I omit that
        // because it is easier to test this way.

        // I wont cheat on exams
        for (int i = 0; i < 100; i++) {
            System.out.println("I won't cheat on exam!");
        }

        // Print even
        for (int i = 2; i < 500; i += 2) {
            System.out.println(i);
        }

        // Multiplication table
        int num = 15;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + num + " = " + (i * num));
        }

        // Count from to
        int first  = 3;
        int second = 6;

        if (second <= first) {
            System.out.println("The second number should be bigger");
        } else {
            for (int i = first; i < second; i++) {
                System.out.println(i);
            }
        }

        // FizzBuzz
        for (int i = 1; i < 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }
}
