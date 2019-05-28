package comgreenfox.todos.controller;

import comgreenfox.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping(value = {"", "/list"})
  public String list(boolean isActive, Model model) {
    model.addAttribute("todos", todoService.findWithQuery(isActive));
    return "todo-list";
  }

}
