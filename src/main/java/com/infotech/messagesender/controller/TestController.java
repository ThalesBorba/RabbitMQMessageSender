package com.infotech.messagesender.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infotech.messagesender.model.ProductRequest;
import com.infotech.messagesender.producer.AuthProducer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.infotech.messagesender.utils.JsonConverter.toJson;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class TestController {

    private final AuthProducer producer;

    @PostMapping("/request")
    public ResponseEntity<String> register(@RequestBody @Valid ProductRequest request) {
        try {
            producer.sendMessage("x-auth-register-request", toJson(request));
            return ResponseEntity.accepted().body("Mensagem enviada com sucesso");
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body("Houve um erro ao converter a mensagem para o formato Json");
        }
    }
}
