package org.example.task1blogwithlogin.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.task1blogwithlogin.dto.BlogPostDTO;
import org.example.task1blogwithlogin.mapper.BlogPostMapper;
import org.example.task1blogwithlogin.model.BlogPost;
import org.example.task1blogwithlogin.repo.BlogPostRepo;
import org.example.task1blogwithlogin.repo.UserRepo;
import org.example.task1blogwithlogin.service.BlogPostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepo blogPostRepo;
    private final BlogPostMapper blogPostMapper;
    private final UserRepo userRepo;
    private final Path rootLocation = Paths.get("uploads");

    @Override
    public BlogPostDTO createBlogPost(BlogPostDTO blogPostDTO, MultipartFile thumbnail) throws IOException {
        if (thumbnail.isEmpty()) {
            throw new IllegalArgumentException("Thumbnail image is required");
        }

        if (!Files.exists(rootLocation)) {
            Files.createDirectories(rootLocation);
        }


        String uniqueFileName = UUID.randomUUID().toString() + "_" + thumbnail.getOriginalFilename();
        Path destinationFile = rootLocation.resolve(uniqueFileName).normalize().toAbsolutePath();


        Files.copy(thumbnail.getInputStream(), destinationFile);


        blogPostDTO.setThumbnail(uniqueFileName);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        blogPostDTO.setUserId(findUserIdByUsername(username));


        BlogPost blogPost = blogPostMapper.toEntity(blogPostDTO);
        return blogPostMapper.toDto(blogPostRepo.save(blogPost));
    }

    private Integer findUserIdByUsername(String username) {
        return userRepo.findUserByEmail(username).get().getId();
    }

    @Override
    public List<BlogPostDTO> getAllBlogPosts() {
        return blogPostRepo.findAll().stream()
                .map(blogPostMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostDTO getBlogPostById(Integer id) {
        return blogPostMapper.toDto(blogPostRepo.findById(id).orElseThrow());
    }

    @Override
    public void deleteBlogPostById(Integer id) {
        blogPostRepo.deleteById(id);
    }
}
