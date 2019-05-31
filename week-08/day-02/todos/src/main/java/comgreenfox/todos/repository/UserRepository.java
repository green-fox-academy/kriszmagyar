package comgreenfox.todos.repository;

import comgreenfox.todos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByName(String name);
}