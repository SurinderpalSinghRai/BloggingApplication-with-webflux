package com.socialMedia.bloggingApplication.handler;

import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.PostServices;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostHandler {
    @Autowired
    private PostServices postServices;

    public Mono<ServerResponse> loadPosts(ServerRequest request){
        Flux<PostDto> postDtoFlux =postServices.getAllPosts();
        return ServerResponse.ok().body(postDtoFlux,PostDto.class);

    }
    public Mono<ServerResponse> getPostById(ServerRequest request){
        String postId = request.pathVariable("input");
        Mono<PostDto> postDtoMono =postServices.getPostById(postId);
        return ServerResponse.ok().body(postDtoMono,PostDto.class);

    }
    public Mono<ServerResponse> updatePost(ServerRequest request){
        String postId = request.pathVariable("input");
        Mono<PostDto> postDtoMono =postServices.updatePost(request.bodyToMono(PostDto.class),postId);
        return ServerResponse.ok().body(postDtoMono,PostDto.class);

    }
    public Mono<ServerResponse> deletePost(ServerRequest request){
        String postId = request.pathVariable("input");
        Mono<Void> monoVoid = postServices.deletePost(postId);
        return ServerResponse.ok().body(monoVoid,PostDto.class);

    }
    public Mono<ServerResponse> addPost(ServerRequest request){
        Mono<PostDto> postDtoMono = request.bodyToMono(PostDto.class);
        Mono<PostDto> postDtoMono1 =postServices.addPost(postDtoMono);
        return ServerResponse.ok().body(postDtoMono1,PostDto.class);

    }
}
