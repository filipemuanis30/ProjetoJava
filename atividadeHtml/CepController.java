package com.exemplo.cepapi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://viacep.com.br/ws")
            .build();

    @GetMapping("/{cep}")
    public Mono<String> buscarCep(@PathVariable String cep) {
        return webClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(String.class);
    }
}
