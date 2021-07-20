package com.babor.springbootall.controllers;

import com.babor.springbootall.rabbitmq.AsyncPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mq")
public class RabbitMqController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RabbitMqController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/send")
    public String productMessage() throws JsonProcessingException {
        int index = (int) ((Math.random()) * (28 - 1)) + 1;

        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);
        payload.setModel("ROOM");

        rabbitTemplate.convertAndSend("operations", "spring.room.cleaner",
                objectMapper.writeValueAsString(payload));

        return "success";
    }
}
