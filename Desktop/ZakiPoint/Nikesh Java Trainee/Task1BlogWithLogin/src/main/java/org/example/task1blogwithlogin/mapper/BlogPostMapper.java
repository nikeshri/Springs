package org.example.task1blogwithlogin.mapper;

import org.example.task1blogwithlogin.dto.BlogPostDTO;
import org.example.task1blogwithlogin.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlogPostMapper {

    @Mapping(source = "user.id", target = "userId")
    BlogPostDTO toDto(BlogPost blogPost);

    @Mapping(source = "userId", target = "user.id")
    BlogPost toEntity(BlogPostDTO blogPostDTO);
}
