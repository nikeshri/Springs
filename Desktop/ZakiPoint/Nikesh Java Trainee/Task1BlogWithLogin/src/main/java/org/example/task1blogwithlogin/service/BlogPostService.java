package org.example.task1blogwithlogin.service;

import org.example.task1blogwithlogin.dto.BlogPostDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogPostService {
    BlogPostDTO createBlogPost(BlogPostDTO blogPostDTO, MultipartFile thumbnail) throws IOException;
    List<BlogPostDTO> getAllBlogPosts();
    BlogPostDTO getBlogPostById(Integer id);
    void deleteBlogPostById(Integer id);
}
