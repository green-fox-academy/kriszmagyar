public class Strings {

  public static void main(String[] args) {

    // Simple replace
    String example = "In a dishwasher far far away";
    example = example.replace("dishwasher", "galaxy");
    System.out.println(example); // expects In a  galaxy far far away

    // URL fixer
    String url = "https//www.reddit.com/r/nevertellmethebots";
    System.out.println(urlFixer(url)); // expects https://www.reddit.com/r/nevertellmetheodds
  }

  private static String urlFixer(String url) {
    String nextUrl = url.replace("bots", "odds");
    nextUrl = insertAt(nextUrl, ":", nextUrl.lastIndexOf("//"));
    return nextUrl;
  }

  private static String insertAt(String str, String insertion, int index) {
    return str.substring(0, index) + insertion + str.substring(index);
  }

}
