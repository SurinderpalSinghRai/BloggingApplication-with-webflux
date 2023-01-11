package com.socialMedia.bloggingApplication.repository;

import com.socialMedia.bloggingApplication.entities.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends ReactiveMongoRepository<Comments,String> {
}
