package comgreenfox.todos.repository;

import comgreenfox.todos.model.Assignee;
import comgreenfox.todos.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByTitleContainsOrDescriptionContains(String title, String description);

  List<Todo> findAllByAssignee(Assignee assignee);

  List<Todo> findAllByDoneTrue();

  List<Todo> findAllByDoneFalse();

  List<Todo> findAllByUrgentTrue();
}
