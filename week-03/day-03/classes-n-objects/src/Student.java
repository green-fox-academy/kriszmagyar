public class Student {

  void learn() {
    System.out.println("Student is learning...");
  }

  void question(Teacher teacher) {
    System.out.println("Student asks a question...");
    teacher.answer();
  }
}
