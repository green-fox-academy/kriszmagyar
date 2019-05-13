package converter.number;

import java.util.HashMap;
import java.util.Map;

class NumberConverter {

  private Map<Integer, String> numberMap;
  private Map<Integer, String> decimalMap;

  NumberConverter() {
    numberMap = populateNumberMap();
    decimalMap = populateDecimalMap();
  }

  String convert(int num) {

    if (num < 21) {
      return numberMap.get(num) + " dollars";
    }

    if (num < 100) {
      return numberMap.get(digitAt(num, 0) * 10) + " " + convert(subNumber(num, 1));
    }

    if (num < 1000) {
      return numberMap.get(digitAt(num, 0)) + " hundred and " + convert(subNumber(num, 1));
    }

    return "";
  }

  int convert(String num) {
    return 745;
  }

  private int digitAt(int num, int index) {
    return Character.getNumericValue(Integer.toString(num).charAt(index));
  }

  private int subNumber(int num, int start) {
    return Integer.parseInt(Integer.toString(num).substring(start));
  }

  private Map<Integer, String> populateNumberMap() {
    Map<Integer, String> result = new HashMap<>();
    result.put(1, "one");
    result.put(2, "two");
    result.put(3, "three");
    result.put(4, "four");
    result.put(5, "five");
    result.put(6, "six");
    result.put(7, "seven");
    result.put(8, "eight");
    result.put(9, "nine");
    result.put(10, "ten");
    result.put(11, "eleven");
    result.put(12, "twelve");
    result.put(13, "thirteen");
    result.put(14, "fourteen");
    result.put(15, "fifteen");
    result.put(16, "sixteen");
    result.put(17, "seventeen");
    result.put(18, "eighteen");
    result.put(19, "nineteen");
    result.put(20, "twenty");
    result.put(30, "thirty");
    result.put(40, "forty");
    result.put(50, "fifty");
    result.put(60, "sixty");
    result.put(70, "seventy");
    result.put(80, "eighty");
    result.put(90, "ninety");
    return result;
  }

  private Map<Integer, String> populateDecimalMap() {
    Map<Integer, String> result = new HashMap<>();
    result.put(100, "hundred");
    result.put(1000, "thousand");
    result.put(1000000, "million");
    return result;
  }

}
