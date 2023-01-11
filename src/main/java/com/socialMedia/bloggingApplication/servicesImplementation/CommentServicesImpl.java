package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.Utils.AppUtils;
import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import com.socialMedia.bloggingApplication.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentServicesImpl implements CommentServices {

    @Autowired
    private CommentsRepository commentsRepository;

    public Mono<CommentDto> addComment(Mono<CommentDto> commentDtoMono){
        return commentDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(commentsRepository::insert)
                .map(AppUtils::entityToDto);

    }

    @Override
    public Mono<CommentDto> updateComment(Mono<CommentDto> commentDto, String commentId) {

        return commentsRepository.findById(commentId)
                .flatMap(u -> commentDto.map(AppUtils::dtoToEntity))
                .doOnNext(e -> e.setComment(e.getComment()))
                .flatMap(commentsRepository::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<CommentDto> getCommentById(String commentId) {
        return this.commentsRepository.findById(commentId).map(AppUtils::entityToDto);

    }

    @Override
    public Flux<CommentDto> getAllComments() {
        return  this.commentsRepository.findAll().map(AppUtils::entityToDto);

    }

    @Override
    public Mono<Void> deleteComment(String commentId) {
        return commentsRepository.deleteById(commentId);

    }
}
