package comgreenfox.todos.repository;

import comgreenfox.todos.model.Todo;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryCustomImpl implements TodoRepositoryCustom {

  @Override
  public List<Todo> findAllActive() {
    System.out.println("From custom query!");
    return Collections.emptyList();
  }
}
