package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/allUser")
    public String printUser(Model model) {
        List<User> users = userService.allUser();
        model.addAttribute("allUser", users);
        return "user";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/allUser";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update"; // Используем ту же форму для редактирования
    }

    @PostMapping("/editUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/allUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/allUser";
    }
}
