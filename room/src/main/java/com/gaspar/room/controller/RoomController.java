package com.gaspar.room.controller;

import com.gaspar.room.services.IRoomService;
import com.gaspar.room.model.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final IRoomService service;

    public RoomController(IRoomService service) {
        this.service = service;
    }

    @GetMapping("rooms")
    public List<Room> search(){
        return service.search();
    }
}
