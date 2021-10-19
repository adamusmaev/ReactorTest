package hello;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpInputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("asdcasd"));
    }

    public Mono<ServerResponse> helloWithUser(ServerRequest request) {
        String user = request.queryParam("user").orElse("NULL");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("user", user);
        return ServerResponse.ok().
                render("index", userMap);
    }
}