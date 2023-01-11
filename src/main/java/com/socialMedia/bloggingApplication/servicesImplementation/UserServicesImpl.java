package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.Utils.AppUtils;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserServicesImpl implements UserServices {


    @Autowired
    private UsersRepository usersRepository;

    public Mono<UserDto> addUser(Mono<UserDto> userDtoMono){
       return userDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(usersRepository::insert)
                .map(AppUtils::entityToDto);

    }

    @Override
    public Mono<UserDto> updateUser(Mono<UserDto> userDto, String userId) {

        return usersRepository.findById(userId)
                .flatMap(u -> userDto.map(AppUtils::dtoToEntity))
                .doOnNext(e -> e.setUserName(e.getUserName()))
                .doOnNext(e -> e.setUserEmail(e.getUserEmail()))
                .doOnNext(e -> e.setUserAddress(e.getUserAddress()))
                .flatMap(usersRepository::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<UserDto> getUserById(String userId) {
        return this.usersRepository.findById(userId).map(AppUtils::entityToDto);

    }


    @Override
    public Flux<UserDto> getAllUsers() {
       return this.usersRepository.findAll().map(AppUtils::entityToDto);

    }
    @Override
    public Mono<Void> deleteUser(String userId) {
        return usersRepository.deleteById(userId);


    }

}
