package comgreenfox.todos.controller;

import comgreenfox.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String loginView(Model model) {
    model.addAttribute("user", userService.getNewInstance());
    return "auth/login";
  }

}
