package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import com.socialMedia.bloggingApplication.services.CommentServices;
import com.socialMedia.bloggingApplication.services.PostServices;
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

public class CommentsController {

    @Autowired
    private CommentServices commentServices;

    @PostMapping ("/addComment")
    public Mono<CommentDto> addComment(@RequestBody Mono<CommentDto> commentDtoMono){
        System.out.println("Coming........");
        return commentServices.addComment(commentDtoMono);


    }

    @GetMapping("/getAllComments")
    public Flux<CommentDto> getAllComments(){
        return commentServices.getAllComments();
    }
    @GetMapping("/getCommentById/{commentId}")
    public Mono<CommentDto> getCommentById(@PathVariable String commentId){
        return commentServices.getCommentById(commentId);

    }
    @PutMapping("/updateComment/{commentId}")
    public Mono<CommentDto> updateComment(@RequestBody Mono<CommentDto> commentDtoMono, @PathVariable String commentId){
        return commentServices.updateComment(commentDtoMono,commentId);
    }
    @DeleteMapping("/deleteComment/{commentId}")
    public Mono<Void> deleteComment(@PathVariable String commentId){
        return this.commentServices.deleteComment(commentId);

    }
}
