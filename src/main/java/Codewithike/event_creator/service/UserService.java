package Codewithike.event_creator.service;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User with this email already exists");
        }
        userRepo.save(user);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

//    public User getUserByEmail(String email) {
//        User user =
//        return userRepo.(email).orElseThrow(() -> new RuntimeException("User not found"));
//    }
}
