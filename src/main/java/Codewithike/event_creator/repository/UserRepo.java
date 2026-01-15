package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    Optional<User> findByFirebaseUid(String firebaseUid);
//    Optional<User> findByEmail(String email);
}
