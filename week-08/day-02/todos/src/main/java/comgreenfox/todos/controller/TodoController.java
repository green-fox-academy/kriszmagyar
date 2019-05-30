package comgreenfox.todos.controller;

import comgreenfox.todos.model.Todo;
import comgreenfox.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping(value = {"", "/list"})
  public String list(String search, Model model) {
    model.addAttribute("todos", todoService.findWithQuery(search));
    return "todo/todo-list";
  }

  @GetMapping("/{id}")
  public String itemView(@PathVariable long id, Model model) {
    model.addAttribute("todo", todoService.findById(id));
    return "todo/todo-item";
  }

  @GetMapping("/add")
  public String addView(Model model) {
    model.addAttribute("todo", todoService.getNewInstance());
    return "todo/todo-add";
  }

  @PostMapping("/add")
  public String add(Todo todo) {
    todoService.add(todo);
    return "redirect:/todos";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable long id) {
    todoService.delete(id);
    return "redirect:/todos";
  }

  @GetMapping("/edit/{id}")
  public String editView(@PathVariable long id, Model model) {
    model.addAttribute("todo", todoService.findById(id));
    return "todo/todo-edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(Todo todo) {
    todoService.edit(todo);
    return "redirect:/todos";
  }

}
