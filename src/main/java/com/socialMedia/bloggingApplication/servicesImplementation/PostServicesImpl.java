package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.Utils.AppUtils;
import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.repository.PostsRepository;
import com.socialMedia.bloggingApplication.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class PostServicesImpl  implements PostServices {
    @Autowired
    private PostsRepository postsRepository;

    public Mono<PostDto> addPost(Mono<PostDto> postDtoMono){
        return postDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(postsRepository::insert)
                .map(AppUtils::entityToDto);

    }

    @Override
    public Mono<PostDto> updatePost(Mono<PostDto> postDto, String postId) {

        return postsRepository.findById(postId)
                .flatMap(u -> postDto.map(AppUtils::dtoToEntity))
                .doOnNext(e -> e.setTitle(e.getTitle()))
                .doOnNext(e -> e.setContent(e.getContent()))
                .flatMap(postsRepository::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PostDto> getPostById(String postId) {
        return this.postsRepository.findById(postId).map(AppUtils::entityToDto);

    }
    @Override
    public Flux<PostDto> getAllPosts() {
        return  this.postsRepository.findAll().map(AppUtils::entityToDto);

    }
    @Override
    public Mono<Void> deletePost(String postId) {
        return postsRepository.deleteById(postId);


    }

}
