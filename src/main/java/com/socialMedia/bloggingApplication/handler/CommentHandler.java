package com.socialMedia.bloggingApplication.handler;

import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.services.CommentServices;
import com.socialMedia.bloggingApplication.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentHandler {

    @Autowired
    private CommentServices commentServices;

    public Mono<ServerResponse> loadComments(ServerRequest request){
        Flux<CommentDto> commentDtoFlux =commentServices.getAllComments();
        return ServerResponse.ok().body(commentDtoFlux,CommentDto.class);

    }
    public Mono<ServerResponse> getCommentById(ServerRequest request){
        String commentId = request.pathVariable("input");
        Mono<CommentDto> commentDtoMono =commentServices.getCommentById(commentId);
        return ServerResponse.ok().body(commentDtoMono,CommentDto.class);

    }
    public Mono<ServerResponse> updateComment(ServerRequest request){
        String commentId = request.pathVariable("input");
        Mono<CommentDto> commentDtoMono =commentServices.updateComment(request.bodyToMono(CommentDto.class),commentId);
        return ServerResponse.ok().body(commentDtoMono,CommentDto.class);

    }
    public Mono<ServerResponse> deleteComment(ServerRequest request){
        String commentId = request.pathVariable("input");
        Mono<Void> monoVoid = commentServices.deleteComment(commentId);
        return ServerResponse.ok().body(monoVoid,CommentDto.class);

    }
    public Mono<ServerResponse> addComment(ServerRequest request){
        Mono<CommentDto> commentDtoMono = request.bodyToMono(CommentDto.class);
        Mono<CommentDto> commentDtoMono1 =commentServices.addComment(commentDtoMono);
        return ServerResponse.ok().body(commentDtoMono1,PostDto.class);

    }
}
