package com.infotech.messagesender.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        Dotenv dotenv = Dotenv.configure().load();
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(dotenv.get("IF_RABBITMQ_HOST"));
        connectionFactory.setPort(Integer.parseInt(dotenv.get("IF_RABBITMQ_PORT")));
        connectionFactory.setUsername(dotenv.get("IF_RABBITMQ_USERNAME"));
        connectionFactory.setPassword(dotenv.get("IF_RABBITMQ_PASSWORD"));
        connectionFactory.setVirtualHost(dotenv.get("IF_RABBITMQ_VHOST"));
        connectionFactory.setConnectionTimeout(30000);
        connectionFactory.setRequestedHeartBeat(30);
        return connectionFactory;
    }

}