import java.util.Arrays;

public class Exercises {

  public static void main(String[] args) {

    int[] q = {4, 5, 6, 7};
    printThird(q); // expects print 6

    int[] first = {1, 2, 3};
    int[] second = {4, 5};
    compareLength(first, second); // expects print First has more elements!

    int[] r = {54, 23, 66, 12};
    sumSecondAndThird(r); // expects print 89

    int[] s = {1, 2, 3, 8, 5, 6};
    changeFourthElementToFour(s);
    System.out.println(s[3]); // expects 4

    int[] t = {1, 2, 3, 4, 5};
    incThirdElement(t);
    System.out.println(t[2]); // expects 4

    int[] numbers = {4, 5, 6, 7};
    printArr(numbers); // expects print [4, 5, 6, 7]

    int[][] matrix = createBaseMatrix(4);
    printMatrix(matrix); // expects print 4x4 matrix, with 1 in diagonals

    int[] numList = {3, 4, 5, 6, 7};
    doubleArr(numList);
    printArr(numList); // expects print [6, 8, 10, 12, 14]

    String[][] colorShades = {
        { "lime", "forest green", "olive", "pale green", "spring green" },
        { "orange red", "red", "tomato" },
        { "orchid", "violet", "pink", "hot pink" }
    };
    System.out.println(Arrays.deepToString(colorShades)); // expects print colorShades array

    String[] animals = {"koal", "pand", "zebr"};
    appendAToAll(animals);
    System.out.println(Arrays.toString(animals)); // expects ["koala", "panda", "zebra"]

    String[] abc = {"first", "second", "third"};
    swapFirstAndLast(abc);
    System.out.println(Arrays.toString(abc)); // expects ["third", "second", "first"]

    int[] ai = {3, 4, 5, 6, 7};
    System.out.println(sum(ai)); // expects 25

    int[] aj = {3, 4, 5, 6, 7};
    reverse(aj);
    printArr(aj); // expects [7, 6, 5, 4, 3]
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

  public static void sumSecondAndThird(int[] arr) {
    System.out.println(arr[1] + arr[2]);
  }

  public static void changeFourthElementToFour(int[] arr) {
    arr[3] = 4;
  }

  public static void incThirdElement(int[] arr) {
    arr[2]++;
  }

  public static void printArr(int[] arr) {
    System.out.print("[");
    int i;
    for (i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[i] + "]");
  }

  public static int[][] createBaseMatrix(int size) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void doubleArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] *= 2;
    }
  }

  public static void appendAToAll(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] += "a";
    }
  }

  public static void swapFirstAndLast(String[] arr) {
    String tmp = arr[0];
    arr[0] = arr[arr.length - 1];
    arr[arr.length - 1] = tmp;
  }

  public static int sum(int[] arr) {
    int res = 0;
    for (int el : arr) {
      res += el;
    }
    return res;
  }

  public static void reverse(int[] arr) {
    int[] tmpArr = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      tmpArr[i] = arr[arr.length - 1 - i];
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = tmpArr[i];
    }
  }

}
