package comgreenfox.todos.service;

import comgreenfox.todos.model.User;
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
  public boolean isValid(User user) {
    return false;
  }

  @Override
  public boolean isExist(User user) {
    return true;
  }
}
