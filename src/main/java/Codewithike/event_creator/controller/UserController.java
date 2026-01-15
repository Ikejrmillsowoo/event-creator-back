package Codewithike.event_creator.controller;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User created";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id , @RequestBody User userDetails) {
        userService.updateUser(id, userDetails);

        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

}
