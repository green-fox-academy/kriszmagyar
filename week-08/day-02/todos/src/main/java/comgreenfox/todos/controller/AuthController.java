package comgreenfox.todos.controller;

import comgreenfox.todos.model.User;
import comgreenfox.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String loginView(@ModelAttribute("error") String error, Model model) {
    model.addAttribute("user", userService.getNewInstance())
      .addAttribute("error", error);
    return "auth/login";
  }

  @PostMapping("/login")
  public String login(User user, RedirectAttributes redirect) {
    if (userService.isValid(user)) {
      return "redirect:/todos";
    }
    redirect.addFlashAttribute("error", "User is invalid!");
    return "redirect:/login";
  }

  @GetMapping("/register")
  public String registerView(@ModelAttribute("error") String error, Model model) {
    model.addAttribute("user", userService.getNewInstance())
        .addAttribute("error", error);
    return "auth/register";
  }

  @PostMapping("/register")
  public String register(User user, RedirectAttributes redirect) {
    if (userService.isExist(user)) {
      redirect.addFlashAttribute("error", "User with name " + user.getUsername() + " is already registered!");
      return "redirect:/register";
    }
    userService.add(user);
    return "redirect:/todos";
  }

}
