package com.greenfoxacademy.dependecies.controller;

import com.greenfoxacademy.dependecies.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gfa")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public String index() {
    return "student/index";
  }

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "student/list";
  }

}
