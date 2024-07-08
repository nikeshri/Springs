package org.example.task1blogwithlogin.repo;

import org.example.task1blogwithlogin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
