package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserServices {
    Mono<UserDto> addUser(Mono<UserDto> user);

    Mono<UserDto> updateUser(Mono<UserDto> user, String userId);
//
    Mono<UserDto> getUserById(String userId);

    Flux<UserDto> getAllUsers();
//
    Mono<Void> deleteUser(String userId);
}
