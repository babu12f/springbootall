package com.babor.springbootall.rabbitmq;

import com.babor.springbootall.models.Room;
import com.babor.springbootall.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper objectMapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper objectMapper, RoomService roomService) {
        this.objectMapper = objectMapper;
        this.roomService = roomService;
    }

    /**
     * simple message published form rabbit mq
     *
     * Set properties: content_type = text/plain
     * EX: {"id": 25, "model": "ROOM"}
     *
     * */
    public void receiveMessage(String message) {
        try {
            AsyncPayload payload = objectMapper.readValue(message, AsyncPayload.class);

            if ("ROOM".equals(payload.getModel())) {
                Room room = roomService.getById(payload.getId());
                LOGGER.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            }
            else {
                LOGGER.warn("Unknown model type");
            }
        }
        catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }

}
