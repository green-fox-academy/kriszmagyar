public class Types {
    public static void main(String[] args) {

        // Introduce yourself
        System.out.println("Krisz");
        System.out.println(26);
        System.out.println(1.85);

        // Two numbers
        System.out.println(22 + 13);
        System.out.println(22 - 13);
        System.out.println(22 * 13);
        System.out.println(22 / 13.);
        System.out.println(22 / 13);
        System.out.println(22 % 13);

        // Coding hours
        int timeSpentCoding = 6 * 5 * 17; // hours * days * weeks
        int workingHours    = 52 * 17;    // hours * weeks

        System.out.println("Time spent with coding: " + timeSpentCoding);
        System.out.println("Coding hours: " + (float) timeSpentCoding / workingHours * 100 + "%");

    }
}
