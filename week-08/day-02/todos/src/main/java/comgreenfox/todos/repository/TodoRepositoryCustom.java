package comgreenfox.todos.repository;

import comgreenfox.todos.model.Todo;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface TodoRepositoryCustom {

  List<Todo> findAllActive();
}
