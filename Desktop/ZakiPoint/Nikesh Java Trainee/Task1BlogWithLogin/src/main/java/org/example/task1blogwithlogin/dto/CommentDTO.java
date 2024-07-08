package org.example.task1blogwithlogin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CommentDTO {
    private String content;
    private Integer userId;
    private Integer blogPostId;
}
