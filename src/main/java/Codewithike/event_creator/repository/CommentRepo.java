package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    //newest comments first
    List<Comment> findAllByOrderByCreatedAtDesc();

    //Oldest comments first
    List<Comment> findAllByOrderByCreatedAtAsc();
}
