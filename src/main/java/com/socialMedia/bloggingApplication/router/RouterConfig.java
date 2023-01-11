package com.socialMedia.bloggingApplication.router;

import com.socialMedia.bloggingApplication.handler.CommentHandler;
import com.socialMedia.bloggingApplication.handler.PostHandler;
import com.socialMedia.bloggingApplication.handler.UserHandler;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Autowired
    private UserHandler userHandler;

    @Autowired
    private PostHandler postHandler;

    @Autowired
    private CommentHandler commentHandler;


    @Bean
    public RouterFunction<ServerResponse> userRouterFunction(){
        return RouterFunctions.route()
                .GET("/router/getAllUsers",userHandler::loadUsers)
                .GET("/router/getUserById/{input}",userHandler::getUserById)
                .PUT("/router/updateUser/{input}",userHandler::updateUser)
                .DELETE("/router/deleteUser/{input}",userHandler::deleteUser)
                .POST("/router/addUser",userHandler::addUser).build();
    }

    @Bean
    public RouterFunction<ServerResponse> postRouterFunction(){
        return RouterFunctions.route()
                .GET("/router/getAllPosts",postHandler::loadPosts)
                .GET("/router/getPostById/{input}",postHandler::getPostById)
                .PUT("/router/updatePost/{input}",postHandler::updatePost)
                .DELETE("/router/deleteUser/{input}",postHandler::deletePost)
                .POST("/router/addUser",postHandler::addPost).build();
    }

    @Bean
    public RouterFunction<ServerResponse> commentRouterFunction(){
        return RouterFunctions.route()
                .GET("/router/getAllComments",commentHandler::loadComments)
                .GET("/router/getCommentById/{input}",commentHandler::getCommentById)
                .PUT("/router/updateComment/{input}",commentHandler::updateComment)
                .DELETE("/router/deleteComment/{input}",commentHandler::deleteComment)
                .POST("/router/addComment",commentHandler::addComment).build();
    }
}
