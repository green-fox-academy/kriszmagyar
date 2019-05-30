package comgreenfox.todos.service;

import comgreenfox.todos.model.Todo;
import java.util.List;

public interface TodoService {

  List<Todo> findAll();

  List<Todo> findWithQuery(String search);

  Todo findById(long id);

  Todo getNewInstance();

  void add(Todo todo);

  void delete(long id);

  void edit(Todo todo);

}
