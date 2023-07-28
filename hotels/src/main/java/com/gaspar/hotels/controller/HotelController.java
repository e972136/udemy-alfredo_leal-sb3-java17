package com.gaspar.hotels.controller;

import com.gaspar.hotels.model.Hotel;
import com.gaspar.hotels.services.IHotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private final IHotelService service;

    public HotelController(IHotelService service) {
        this.service = service;
    }

    @GetMapping("hotels")
    public List<Hotel> serch(){
        return  service.search();
    }
}
