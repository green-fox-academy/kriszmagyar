package comgreenfox.todos.service;

import comgreenfox.todos.model.User;
import comgreenfox.todos.model.ValidationError;

public interface UserService {

  User getNewInstance();

  void add(User user);

  ValidationError getLoginValidationError(User user);

  ValidationError getRegisterValidationError(User user);
}
