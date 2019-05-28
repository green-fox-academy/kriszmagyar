package comgreenfox.todos;

import comgreenfox.todos.model.Todo;
import comgreenfox.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosApplication implements CommandLineRunner {

  @Autowired
  private TodoService todoService;

  public static void main(String[] args) {
    SpringApplication.run(TodosApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoService.save(new Todo("Learn OBM"));
  }
}
