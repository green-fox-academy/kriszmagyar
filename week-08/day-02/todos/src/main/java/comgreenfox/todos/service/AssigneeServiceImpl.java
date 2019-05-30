package comgreenfox.todos.service;

import comgreenfox.todos.model.Assignee;
import comgreenfox.todos.repository.AssigneeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImpl implements AssigneeService {

  @Autowired
  private AssigneeRepository assigneeRepository;

  @Override
  public List<Assignee> findAll() {
    List<Assignee> assignees = new ArrayList<>();
    assigneeRepository.findAll().forEach(assignees::add);
    return assignees;
  }

  @Override
  public List<Assignee> findWithQuery(String search) {
    if (search == null || search.isEmpty()) {
      return findAll();
    }
    return assigneeRepository.findAllByNameContainsOrEmailContains(search, search);
  }

  @Override
  public Assignee findById(long id) {
    return assigneeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Assignee with id " + id + " is not exists!"));
  }

  @Override
  public Assignee getNewInstance() {
    return new Assignee();
  }

  @Override
  public void add(Assignee todo) {
    assigneeRepository.save(todo);
  }

  @Override
  public void delete(long id) {
    assigneeRepository.deleteById(id);
  }

  @Override
  public void edit(Assignee todo) {
    assigneeRepository.save(todo);
  }

}
