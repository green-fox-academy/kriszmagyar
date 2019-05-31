package comgreenfox.todos.service;

import comgreenfox.todos.model.User;
import comgreenfox.todos.model.ValidationError;
import comgreenfox.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getNewInstance() {
    return new User();
  }

  @Override
  public void add(User user) {
    userRepository.save(user);
  }

  @Override
  public ValidationError getLoginValidationError(User user) {
    return null;
  }

  public boolean isValid(User user) {
    User userInRepo = userRepository.findByName(user.getName());
    if (userInRepo == null) {
      return false;
    }
    return !user.getPassword().equals(userInRepo.getPassword());
  }

  @Override
  public ValidationError getRegisterValidationError(User user) {
    ValidationError error = new ValidationError();
    if (isExist(user)) {
      error.setUsername("User with name " + user.getName() + " is already registered!");
      return error;
    }
    return null;
  }

  private boolean isExist(User user) {
    return userRepository.findByName(user.getName()) != null;
  }

}
