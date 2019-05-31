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
    ValidationError error = new ValidationError();
    if (!isValidUsername(user.getName())) {
      error.setUsername("This user is not exist!");
      return error;
    }
    if (!isValidPassword(user)) {
      error.setPassword("Password is incorrect!");
      return error;
    }
    return null;
  }

  private boolean isValidUsername(String username) {
    return userRepository.findByName(username) != null;
  }

  private boolean isValidPassword(User user) {
    User userInRepo = userRepository.findByName(user.getName());
    return userInRepo.getPassword().equals(user.getPassword());
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
