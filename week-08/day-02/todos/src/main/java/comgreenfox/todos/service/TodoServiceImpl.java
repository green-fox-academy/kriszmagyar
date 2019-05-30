package comgreenfox.todos.service;

import comgreenfox.todos.model.Assignee;
import comgreenfox.todos.model.Todo;
import comgreenfox.todos.repository.TodoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public List<Todo> findAll() {
    List<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    return todos;
  }

  @Override
  public List<Todo> findWithQuery(String search) {
    if (search == null || search.isEmpty()) {
      return findAll();
    }
    return findWithValidQuery(search);
  }

  private List<Todo> findWithValidQuery(String search) {
    switch (search.toLowerCase()) {
      case "done":
        return todoRepository.findAllByDoneTrue();
      case "active":
        return todoRepository.findAllByDoneFalse();
      case "urgent":
        return todoRepository.findAllByUrgentTrue();
      default:
        return todoRepository.findAllByTitleContainsOrDescriptionContains(search, search);
    }
  }

  @Override
  public List<Todo> findAllByAssignee(Assignee assignee) {
    return todoRepository.findAllByAssignee(assignee);
  }

  @Override
  public Todo findById(long id) {
    return todoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Todo with id " + id + " is not exists!"));
  }

  @Override
  public Todo getNewInstance() {
    return new Todo();
  }

  @Override
  public void add(Todo todo) {
    todoRepository.save(todo);
  }

  @Override
  public void delete(long id) {
    todoRepository.deleteById(id);
  }

  @Override
  public void edit(Todo todo) {
    todoRepository.save(todo);
  }
}
