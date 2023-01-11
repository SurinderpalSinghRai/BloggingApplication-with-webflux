package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.PostServices;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostServices postServices;

    @PostMapping ("/addPost")
    public Mono<PostDto> addPost(@RequestBody Mono<PostDto> postDtoMono){
        System.out.println("Coming........");
        return postServices.addPost(postDtoMono);


    }

    @GetMapping("/getAllPosts")
    public Flux<PostDto> getAllPosts(){
        return postServices.getAllPosts();
    }
    @GetMapping("/getPostById/{postId}")
    public Mono<PostDto> getPostById(@PathVariable String postId){
        return postServices.getPostById(postId);

    }
    @PutMapping("/updatePost/{postId}")
    public Mono<PostDto> updatePost(@RequestBody Mono<PostDto> postDtoMono, @PathVariable String postId){
        return postServices.updatePost(postDtoMono,postId);
    }
    @DeleteMapping("/deletePost/{postId}")
    public Mono<Void> deletePost(@PathVariable String postId){
        return this.postServices.deletePost(postId);

    }
}
