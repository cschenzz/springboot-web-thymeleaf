package com.example;

import com.example.model.Message;
import com.example.repository.InMemoryMessageRepository;
import com.example.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;


@SpringBootApplication
public class ThymeleafApplication {

    @Bean
    public MessageRepository messageRepository() {
        return new InMemoryMessageRepository();
    }

    @Bean
    public Converter<String, Message> messageConverter() {
        return new Converter<String, Message>() {
            @Override
            public Message convert(String id) {
                return messageRepository().findMessage(Long.valueOf(id));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
        System.out.println("~~~~~~(_o_)----99999.running----(^o^)~~~~~~~");
    }

}
