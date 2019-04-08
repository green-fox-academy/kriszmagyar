public class Exercises {

  public static void main(String[] args) {

    int[] q = {4, 5, 6, 7};
    printThird(q); // expects print 6

    int[] first = {1, 2, 3};
    int[] second = {4, 5};
    compareLength(first, second); // expects print First has more elements!

  }

  public static void printThird(int[] arr) {
    System.out.println(arr[2]);
  }

  public static void compareLength(int[] first, int[] second) {
    if (first.length > second.length) {
      System.out.println("First has more elements!");
    } else if (first.length < second.length) {
      System.out.println("Second has more elements!");
    } else {
      System.out.println("The number of elements are the same!");
    }
  }

}
