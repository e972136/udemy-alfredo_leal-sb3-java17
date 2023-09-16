package com.gaspar.room.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gaspar.room.config.RoomConfiguration;
import com.gaspar.room.model.PropertiesRoom;
import com.gaspar.room.services.IRoomService;
import com.gaspar.room.model.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final IRoomService service;
    private final RoomConfiguration roomConfiguration;

    public RoomController(IRoomService service, RoomConfiguration roomConfiguration) {
        this.service = service;
        this.roomConfiguration = roomConfiguration;
    }

    @GetMapping("rooms")
    public List<Room> search(){
        return service.search();
    }

    @GetMapping("/rooms/read/properties")
    public String getProperties() throws JsonProcessingException{
        PropertiesRoom propertiesRoom = PropertiesRoom.of(
                roomConfiguration.getMsg(),
                roomConfiguration.getBuildVersion(),
                roomConfiguration.getMailDetails()
        );
//        String s = new ObjectMapper()
//                .writer()
//                .withDefaultPrettyPrinter()
//                .writeValueAsString(propertiesRoom);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String s = ow.writeValueAsString(propertiesRoom);
        return s;
    }
}
