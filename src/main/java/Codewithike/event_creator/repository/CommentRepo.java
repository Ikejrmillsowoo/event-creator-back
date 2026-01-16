package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    //newest comments first
    List<Comment> findAllByOrderByCreatedAtDesc();

    //Oldest comments first
    List<Comment> findAllByOrderByCreatedAtAsc();
}
