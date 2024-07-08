package org.example.task1blogwithlogin.service;

import org.example.task1blogwithlogin.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
    List<CommentDTO> getAllCommentsForBlogPost(Integer blogPostId);
    void deleteCommentById(Integer id);
}
