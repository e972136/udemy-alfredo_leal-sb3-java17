package com.gaspar.hotels.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gaspar.hotels.model.Hotel;
import com.gaspar.hotels.model.PropertiesHotels;
import com.gaspar.hotels.model.responses.HotelReservations;
import com.gaspar.hotels.model.responses.HotelRooms;
import com.gaspar.hotels.services.IHotelService;
import com.gaspar.hotels.config.HotelsConfiguration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private final IHotelService service;
    private final HotelsConfiguration configuration;

    public HotelController(IHotelService service, HotelsConfiguration configuration) {
        this.service = service;
        this.configuration = configuration;
    }

    @GetMapping("/hotels")
    public List<Hotel> serch(){
        return  service.search();
    }

    @GetMapping("/hotels/rooms/{hotelId}")
    public HotelRooms roomsByHotel(
            @PathVariable long hotelId
    ){
        return service.roomsByHotel(hotelId);
    }

    @GetMapping("/hotels/reservations/{hotelId}")
    public HotelReservations findReservations(
            @PathVariable long hotelId
    ){
        return service.findReservationsByHotel(hotelId);
    }

    @GetMapping("/hotels/read/properties")
    public String getPropertiesHotels() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        PropertiesHotels propertiesHotels = PropertiesHotels.of(
                configuration.getMsg()
                ,configuration.getBuildVersion()
                ,configuration.getMailDetails()
        );
        String json = ow.writeValueAsString(propertiesHotels);
        return json;
    }
}
