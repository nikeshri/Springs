package org.example.task1blogwithlogin.mapper;

import org.example.task1blogwithlogin.dto.CommentDTO;
import org.example.task1blogwithlogin.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "blogPost.id", target = "blogPostId")
    CommentDTO toDto(Comment comment);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "blogPostId", target = "blogPost.id")
    Comment toEntity(CommentDTO commentDTO);
}
