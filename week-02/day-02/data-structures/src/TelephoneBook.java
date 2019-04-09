import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {

  public static void main(String[] args) {

    Map<String, String> phoneBook = new HashMap<>();
    phoneBook.put("William A. Lathan",	"405-709-1865");
    phoneBook.put("John K. Miller",	"402-247-8568");
    phoneBook.put("Hortensia E. Foster",	"606-481-6467");
    phoneBook.put("Amanda D. Newland",	"319-243-5613");
    phoneBook.put("Brooke P. Askew",	"307-687-2982");

    System.out.println("Phone number of John K. Miller: " + phoneBook.get("John K. Miller"));
    System.out.println("Whose phone number is 307-687-2982? " + getKeyByValue(phoneBook, "307-687-2982"));
    System.out.println("Do we know Chris E. Myers phone number? " + phoneBook.containsKey("Chris E. Myers"));

  }

  private static String getKeyByValue(Map<String, String> map, String value) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    return "";
  }

}
