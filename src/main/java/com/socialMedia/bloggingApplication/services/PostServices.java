package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostServices {
    Mono<PostDto> addPost(Mono<PostDto> postDtoMono);

    Mono<PostDto> updatePost(Mono<PostDto> postDto, String postId);

    Mono<PostDto> getPostById(String postId);

    Flux<PostDto> getAllPosts();

    Mono<Void> deletePost(String postId);
}
