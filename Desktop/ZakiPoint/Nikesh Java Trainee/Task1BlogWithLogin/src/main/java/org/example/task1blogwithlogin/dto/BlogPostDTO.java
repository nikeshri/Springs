package org.example.task1blogwithlogin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogPostDTO {
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private String thumbnail;
    private Integer userId;
    private List<CommentDTO> comments;
}
