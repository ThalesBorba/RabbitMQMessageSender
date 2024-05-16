package com.infotech.messagesender.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.amqp.core.Message;

import java.io.IOException;

@UtilityClass
public class JsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T fromJson(Message message, Class<T> valueType) throws IOException {
        String stringMessage = new String(message.getBody()).replace("\\", "");
        return objectMapper.readValue(stringMessage.substring(1, stringMessage.length() -1), valueType);
    }

}
