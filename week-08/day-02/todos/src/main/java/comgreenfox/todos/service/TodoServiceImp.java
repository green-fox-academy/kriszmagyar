package comgreenfox.todos.service;

import comgreenfox.todos.model.Todo;
import comgreenfox.todos.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImp implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public List<Todo> findAll() {
    List<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    return todos;
  }

  @Override
  public List<Todo> findWithQuery(boolean isActive) {
    return findAll().stream()
        .filter(t -> !t.isDone() || !isActive)
        .collect(Collectors.toList());
  }

  @Override
  public void save(Todo todo) {
    todoRepository.save(todo);
  }
}
