package org.example.task1blogwithlogin.repo;

import org.example.task1blogwithlogin.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost, Integer> {
}
