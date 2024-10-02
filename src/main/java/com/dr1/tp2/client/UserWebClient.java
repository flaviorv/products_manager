package com.dr1.tp2.client;
import com.dr1.tp2.model.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/")
public class UserWebClient {
    private final WebClient webClient;

    public UserWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @GetMapping("/users/{id}")
    public Mono<User> getForecast(@PathVariable String id) {

         return webClient.get().uri("/users/" + id).retrieve().bodyToMono(User.class);

    }
}
