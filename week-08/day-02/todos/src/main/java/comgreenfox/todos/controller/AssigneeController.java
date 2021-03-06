package comgreenfox.todos.controller;

import comgreenfox.todos.model.Assignee;
import comgreenfox.todos.service.AssigneeService;
import comgreenfox.todos.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assignees")
public class AssigneeController {

  private final AssigneeService assigneeService;
  private final TodoService todoService;

  public AssigneeController(AssigneeService assigneeService,
      TodoService todoService) {
    this.assigneeService = assigneeService;
    this.todoService = todoService;
  }

  @GetMapping(value = {"", "/list"})
  public String list(String search, Model model) {
    model.addAttribute("assignees", assigneeService.findWithQuery(search));
    return "assignee/assignee-list";
  }

  @GetMapping("/{id}")
  public String itemView(@PathVariable long id, Model model) {
    Assignee assignee = assigneeService.findById(id);
    model.addAttribute("assignee", assignee);
    model.addAttribute("todos", todoService.findAllByAssignee(assignee));
    return "assignee/assignee-item";
  }

  @GetMapping("/add")
  public String addView(Model model) {
    model.addAttribute("assignee", assigneeService.getNewInstance());
    return "assignee/assignee-add";
  }

  @PostMapping("/add")
  public String add(Assignee assignee) {
    assigneeService.add(assignee);
    return "redirect:/assignees";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable long id) {
    assigneeService.delete(id);
    return "redirect:/assignees";
  }

  @GetMapping("/edit/{id}")
  public String editView(@PathVariable long id, Model model) {
    model.addAttribute("assignee", assigneeService.findById(id));
    return "assignee/assignee-edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(Assignee assignee) {
    assigneeService.edit(assignee);
    return "redirect:/assignees";
  }

}
