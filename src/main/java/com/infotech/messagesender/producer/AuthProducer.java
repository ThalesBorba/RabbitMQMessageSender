package com.infotech.messagesender.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.infotech.messagesender.utils.JsonConverter.toJson;

@Component
@RequiredArgsConstructor
public class AuthProducer {

    private final RabbitTemplate rabbitTemplate;

    MessagePostProcessor messagePostProcessor = message -> {
        message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_JSON);
        return message;
    };

    public void sendMessage(String queueName, Object message) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(queueName, "", toJson(message), messagePostProcessor);
    }

}
