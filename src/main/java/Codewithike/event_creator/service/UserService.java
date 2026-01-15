package Codewithike.event_creator.service;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("User email cannot be null or empty");
        }
        return userRepo.save(user);
    }

    public Optional<User> getUserById(Long id) {
        if (id == null) {
            throw new RuntimeException("User ID cannot be null");
        }
        return userRepo.findById(id);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepo.delete(user);
    }

}
