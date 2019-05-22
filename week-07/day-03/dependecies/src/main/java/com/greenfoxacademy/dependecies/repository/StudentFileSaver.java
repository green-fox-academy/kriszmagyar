package com.greenfoxacademy.dependecies.repository;

import com.greenfoxacademy.dependecies.model.Student;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class StudentFileSaver implements Saver {

  private static final String FILE_NAME = "static/names.txt";

  private List<Student> students;

  public StudentFileSaver() {
    List<String> names = getNamesFromFile();
    populateStudents(names);
  }

  private void populateStudents(List<String> names) {
    students = names.stream()
        .map(Student::new)
        .collect(Collectors.toList());
  }

  private List<String> getNamesFromFile() {
    try {
      File file = new ClassPathResource(FILE_NAME).getFile();
      return Files.readAllLines(file.toPath());
    } catch (IOException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Student> get() {
    return students;
  }

  @Override
  public void save(Student student) {
    students.add(student);
  }
}
