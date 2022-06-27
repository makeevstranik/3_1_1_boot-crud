package com.makeev.bootcrud.pp_3_1_1_bootcrud.controller;

import com.makeev.bootcrud.pp_3_1_1_bootcrud.model.User;
import com.makeev.bootcrud.pp_3_1_1_bootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        //System.out.println(userService.getUsersByName("Elsa").stream().findFirst().orElse(new User()).toString() + "<-------");
        return "/users/index";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/newUser";
    }

    @GetMapping("/details/{id}")
    public String showUserDetails(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            model.addAttribute("id", id);
            return "/users/userNotExist";
        } else {
            model.addAttribute("user", user.get());
            return "/users/userDetails";
        }
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            model.addAttribute("id", id);
            return "/users/userNotExist";
        } else {
            model.addAttribute("user", user.get());
            return "/users/edit";
        }
    }

    @PostMapping("/create")
    public String crateUserFromForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) { // get ready person from view
        // in case bad validation:
        if (bindingResult.hasErrors()) { return "/users/newUser"; }
        userService.add(user);
        return "redirect:/users"; // go to /users
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
