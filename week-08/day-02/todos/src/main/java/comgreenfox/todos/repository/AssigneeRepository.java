package comgreenfox.todos.repository;

import comgreenfox.todos.model.Assignee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {

  List<Assignee> findAllByNameContainsOrEmailContains(String name, String email);
}
