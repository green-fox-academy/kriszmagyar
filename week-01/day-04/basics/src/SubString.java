public class SubString {
    public static void main(String[] args) {

        //  should print: `17`
        System.out.println(subStr("this is what I'm searching in", "searching"));

        //  should print: `-1`
        System.out.println(subStr("this is what I'm searching in", "not"));

    }

    public static int subStr(String input, String q) {
        return input.indexOf(q);
    }

}
