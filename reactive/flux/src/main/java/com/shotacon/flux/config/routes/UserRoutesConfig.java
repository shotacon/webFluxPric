package com.shotacon.flux.config.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.shotacon.flux.handler.UserHandler;

@Configuration
public class UserRoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler) {
        return RouterFunctions
                .route(GET("/api/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleFindAllUser)

                .andRoute(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleFindUserById)

                .andRoute(POST("/api/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::handlePostUser)
                
                .andRoute(DELETE("/api/user/{id}"), userHandler::handleDeleteUser);
    }

}
