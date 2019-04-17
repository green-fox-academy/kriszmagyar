public class Counter {
  private int count;
  private int defaultCount;

  Counter() {
    this.count = 0;
    this.defaultCount = 0;
  }

  Counter(int count) {
    this.count = count;
    this.defaultCount = count;
  }

  void add() {
    count++;
  }

  void add(int number) {
    count += number;
  }

  int get() {
    return count;
  }

  void reset() {
    count = defaultCount;
  }
}
