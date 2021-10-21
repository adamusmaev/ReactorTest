package com.controller;


import com.domain.Message;
import com.service.MessageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class MainController {

    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> list(@RequestParam ServerRequest request) {
        Long start = request.queryParam("start").
                map(Long::new).
                orElse(0L);
        Long count = request.queryParam("count").
                map(Long::new)
                .orElse(2L);
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> add(Message message) {
        return messageService.addOne(message);
    }
}
