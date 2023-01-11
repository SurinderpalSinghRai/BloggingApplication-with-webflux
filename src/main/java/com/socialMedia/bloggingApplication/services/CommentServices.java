package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CommentServices {

    Mono<CommentDto> addComment(Mono<CommentDto> commentDto);

    Mono<CommentDto> updateComment(Mono<CommentDto> commentDto, String commentId);

    Mono<CommentDto> getCommentById(String commentId);

    Flux<CommentDto> getAllComments();

    Mono<Void> deleteComment(String commentId);
}
