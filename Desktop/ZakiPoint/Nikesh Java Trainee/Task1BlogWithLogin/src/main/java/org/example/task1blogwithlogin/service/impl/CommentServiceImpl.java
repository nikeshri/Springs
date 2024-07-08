package org.example.task1blogwithlogin.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.task1blogwithlogin.dto.CommentDTO;
import org.example.task1blogwithlogin.mapper.CommentMapper;
import org.example.task1blogwithlogin.model.Comment;
import org.example.task1blogwithlogin.repo.CommentRepo;
import org.example.task1blogwithlogin.repo.UserRepo;
import org.example.task1blogwithlogin.repo.BlogPostRepo;
import org.example.task1blogwithlogin.service.CommentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;
    private final UserRepo userRepo;
    private final BlogPostRepo blogPostRepo;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Integer userId = findUserIdByUsername(username);
        commentDTO.setUserId(userId);

        Integer blogPostId = findBlogPostIdByCommentDTO(commentDTO);
        commentDTO.setBlogPostId(blogPostId);

        Comment comment = commentMapper.toEntity(commentDTO);
        return commentMapper.toDto(commentRepo.save(comment));
    }

    @Override
    public List<CommentDTO> getAllCommentsForBlogPost(Integer blogPostId) {
        return commentRepo.findAll().stream()
                .filter(comment -> comment.getBlogPost().getId().equals(blogPostId))
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepo.deleteById(id);
    }

    private Integer findUserIdByUsername(String username) {
        return userRepo.findUserByEmail(username).get().getId();
    }

    private Integer findBlogPostIdByCommentDTO(CommentDTO commentDTO) {
        return blogPostRepo.findById(commentDTO.getBlogPostId()).get().getId();
    }
}
