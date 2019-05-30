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
  public List<Todo> findWithQuery(String search) {
    if (search == null || search.isEmpty()) {
      return findAll();
    }
    return todoRepository.findAllByTitleContainsOrDescriptionContains(search, search);
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
