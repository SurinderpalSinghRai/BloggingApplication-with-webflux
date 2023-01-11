package com.socialMedia.bloggingApplication.Utils;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;

public class AppUtils {


    public static UserDto entityToDto(Users user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static Users dtoToEntity(UserDto userDto) {
        Users user = new Users();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static PostDto entityToDto(Posts post) {
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto);
        return postDto;
    }

    public static Posts dtoToEntity(PostDto postDto) {
        Posts post = new Posts();
        BeanUtils.copyProperties(postDto, post);
        return post;
    }

    public static CommentDto entityToDto(Comments comment) {
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment, commentDto);
        return commentDto;
    }

    public static Comments dtoToEntity(CommentDto commentDto) {
        Comments comment = new Comments();
        BeanUtils.copyProperties(commentDto, comment);
        return comment;
    }
}