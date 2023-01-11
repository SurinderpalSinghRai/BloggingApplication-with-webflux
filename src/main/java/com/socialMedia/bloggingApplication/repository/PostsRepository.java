package com.socialMedia.bloggingApplication.repository;

import com.socialMedia.bloggingApplication.entities.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends ReactiveMongoRepository<Posts,String> {
}
