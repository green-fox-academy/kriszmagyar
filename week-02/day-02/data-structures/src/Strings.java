public class Strings {

  public static void main(String[] args) {

    // Simple replace
    String example = "In a dishwasher far far away";
    example = example.replace("dishwasher", "galaxy");
    System.out.println(example); // expects In a  galaxy far far away

    // URL fixer
    String url = "https//www.reddit.com/r/nevertellmethebots";
    url = urlFixer(url);
    System.out.println(url); // expects https://www.reddit.com/r/nevertellmetheodds

    // Takes longer
    String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
    quote = addTakesLonger(quote);
    System.out.println(quote); // expects to add 'always takes longer than'

    // TodoPrint
    String todoText = " - Buy milk\n";
    todoText = buildTodo(todoText);
    System.out.println(todoText); // expects to do list printed

  }

  private static String urlFixer(String url) {
    String nextUrl = url.replace("bots", "odds");
    nextUrl = insertAt(nextUrl, ":", nextUrl.lastIndexOf("//"));
    return nextUrl;
  }

  private static String insertAt(String str, String insertion, int index) {
    return str.substring(0, index) + insertion + str.substring(index);
  }

  /**
   * When saving this quote a disk error has occured. Please fix it.
   * Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
   * Using pieces of the quote variable (instead of just redefining the string)
   */
  private static String addTakesLonger(String str) {
    int insertAtIndex = str.indexOf("you expect,");
    return new StringBuilder(str).insert(insertAtIndex, "always takes longer than ").toString();
  }

  /**
   * Add "My to do:" to the beginning of the todoText
   * Add " - Download games" to the end of the todoText
   * Add " - Diablo" to the end of the todoText but with indention
   */
  private static String buildTodo(String todoText) {
    return new StringBuilder(todoText)
        .insert(0, "My todo:\n")
        .append(" - Download games\n")
        .append("\t - Diablo")
        .toString();
  }

}
