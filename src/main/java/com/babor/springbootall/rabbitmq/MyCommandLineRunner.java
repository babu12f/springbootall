package com.babor.springbootall.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    private ConfigurableApplicationContext context;

    public MyCommandLineRunner(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        /*int index = (int) ((Math.random()) * (28 - 1)) + 1;

        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);
        payload.setModel("ROOM");

        rabbitTemplate.convertAndSend("operations", "spring.room.cleaner",
                objectMapper.writeValueAsString(payload));
        context.close();*/
    }
}
