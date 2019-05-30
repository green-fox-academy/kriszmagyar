package comgreenfox.todos.service;

import comgreenfox.todos.model.Assignee;
import comgreenfox.todos.model.Todo;
import java.util.List;

public interface AssigneeService {

  List<Assignee> findAll();

  List<Assignee> findWithQuery(String search);

  Assignee findById(long id);

  Assignee getNewInstance();

  void add(Assignee todo);

  void delete(long id);

  void edit(Assignee todo);
}
