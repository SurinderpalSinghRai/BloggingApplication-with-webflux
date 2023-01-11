package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
public class UsersController {


    @Autowired
    private UserServices userServices;

    @PostMapping ("/addUser")
    public Mono<UserDto> addUser(@RequestBody Mono<UserDto> user){
        System.out.println("Coming........");
        return userServices.addUser(user);


    }

    @GetMapping("/getAllUsers")
    public Flux<UserDto> getAllUsers(){
        return userServices.getAllUsers();
    }
    @GetMapping("/getUserById/{userId}")
    public Mono<UserDto> getUserById(@PathVariable String userId){
        return userServices.getUserById(userId);

    }
    @PutMapping("/updateUser/{userId}")
    public Mono<UserDto> updateUser(@RequestBody Mono<UserDto> userDtoMono, @PathVariable String userId){
        return userServices.updateUser(userDtoMono,userId);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public Mono<Void> deleteUser(@PathVariable String userId){
       return this.userServices.deleteUser(userId);

    }


}
