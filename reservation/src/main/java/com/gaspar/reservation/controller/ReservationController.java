package com.gaspar.reservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaspar.reservation.config.ReservationConfig;
import com.gaspar.reservation.model.PropertiesReservation;
import com.gaspar.reservation.model.Reservation;
import com.gaspar.reservation.services.IReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReservationController {
    private final IReservationService service;
    private final ReservationConfig reservationConfig;
    public ReservationController(IReservationService service, ReservationConfig reservationConfig) {
        this.service = service;
        this.reservationConfig = reservationConfig;
    }

    @GetMapping("/reservations")
    public List<Reservation> search(){
        return service.search();
    }


    @GetMapping("/reservations/byroom/{idRoom}")
    public List<Reservation> searchByRoom(
        @PathVariable long idRoom
    ){
        return service.searchByRoom(idRoom);
    }

    @GetMapping("/reservations/read/properties")
    public String getProperties()  throws JsonProcessingException {
        PropertiesReservation propertiesReservation = PropertiesReservation.of(
                reservationConfig.getMsg(),
                reservationConfig.getBuildVersion(),
                reservationConfig.getMailDetails()
        );
        String s = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(propertiesReservation);
        return s;
    }
}
