package comgreenfox.todos.repository;

import comgreenfox.todos.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByDoneFalse();
}
