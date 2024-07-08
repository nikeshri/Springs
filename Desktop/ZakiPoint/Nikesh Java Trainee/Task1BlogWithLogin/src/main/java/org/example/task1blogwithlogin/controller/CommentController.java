package org.example.task1blogwithlogin.controller;

import lombok.RequiredArgsConstructor;
import org.example.task1blogwithlogin.dto.CommentDTO;
import org.example.task1blogwithlogin.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }

    @GetMapping("/blogPost/{blogPostId}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsForBlogPost(@PathVariable Integer blogPostId) {
        return ResponseEntity.ok(commentService.getAllCommentsForBlogPost(blogPostId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Integer id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }
}
