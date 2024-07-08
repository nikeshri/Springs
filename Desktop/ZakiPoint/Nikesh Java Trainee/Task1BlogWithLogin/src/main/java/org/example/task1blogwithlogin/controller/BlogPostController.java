package org.example.task1blogwithlogin.controller;

import lombok.RequiredArgsConstructor;
import org.example.task1blogwithlogin.dto.BlogPostDTO;
import org.example.task1blogwithlogin.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/blogPosts")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<BlogPostDTO> createBlogPost(
            @RequestPart("blogPost") BlogPostDTO blogPostDTO,
            @RequestPart("thumbnail") MultipartFile thumbnail) throws IOException {
        return ResponseEntity.ok(blogPostService.createBlogPost(blogPostDTO, thumbnail));
    }

    @GetMapping
    public ResponseEntity<List<BlogPostDTO>> getAllBlogPosts() {
        return ResponseEntity.ok(blogPostService.getAllBlogPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDTO> getBlogPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogPostService.getBlogPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPostById(@PathVariable Integer id) {
        blogPostService.deleteBlogPostById(id);
        return ResponseEntity.noContent().build();
    }
}
