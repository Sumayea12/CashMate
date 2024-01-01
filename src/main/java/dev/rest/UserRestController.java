package dev.rest;
import dev.domain.User;
import dev.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Queue;
@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User addUser(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "Successful";
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "Successful";
    }
}
