package com.socialMedia.bloggingApplication.handler;

import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {

    @Autowired
    private UserServices userServices;

    public Mono<ServerResponse> loadUsers(ServerRequest request){
        Flux<UserDto> userDtoFlux =userServices.getAllUsers();
        return ServerResponse.ok().body(userDtoFlux,UserDto.class);

    }
    public Mono<ServerResponse> getUserById(ServerRequest request){
       String userId = request.pathVariable("input");
       Mono<UserDto> userDtoMono =userServices.getUserById(userId);
        return ServerResponse.ok().body(userDtoMono,UserDto.class);

    }
    public Mono<ServerResponse> updateUser(ServerRequest request){
        String userId = request.pathVariable("input");
        Mono<UserDto> userDtoMono =userServices.updateUser(request.bodyToMono(UserDto.class),userId);
        return ServerResponse.ok().body(userDtoMono,UserDto.class);

    }
    public Mono<ServerResponse> deleteUser(ServerRequest request){
        String userId = request.pathVariable("input");
        Mono<Void> monoVoid = userServices.deleteUser(userId);
        return ServerResponse.ok().body(monoVoid,UserDto.class);

    }
    public Mono<ServerResponse> addUser(ServerRequest request){
        Mono<UserDto> userDtoMono = request.bodyToMono(UserDto.class);
        Mono<UserDto> userDtoMono1 =userServices.addUser(userDtoMono);
        return ServerResponse.ok().body(userDtoMono1,UserDto.class);

    }

}
