package comgreenfox.todos.service;

import comgreenfox.todos.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public User getNewInstance() {
    return new User();
  }
}
