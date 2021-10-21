package com.handlers;

import com.domain.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Long start = request.queryParam("start").
                map(Long::new).
                orElse(0L);


        Long count = request.queryParam("count").
                map(Long::new)
                .orElse(2L);


        Flux<Message> data = Flux.just("1", "2", "3", "4").map(Message::new)
                .skip(start)
                .take(count);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(data, Message.class);
    }

    public Mono<ServerResponse> helloWithUser(ServerRequest request) {
        String user = request.queryParam("user").orElse("NULL");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("user", user);
        return ServerResponse.ok().
                render("index", userMap);
    }
}