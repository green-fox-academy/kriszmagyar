package comgreenfox.todos.service;

import comgreenfox.todos.model.User;

public interface UserService {

  User getNewInstance();

  void add(User user);

  boolean isValid(User user);

}
