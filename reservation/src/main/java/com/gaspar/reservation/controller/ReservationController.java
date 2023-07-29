package com.gaspar.reservation.controller;

import com.gaspar.reservation.model.Reservation;
import com.gaspar.reservation.services.IReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReservationController {
    private final IReservationService service;

    public ReservationController(IReservationService service) {
        this.service = service;
    }

    @GetMapping("reservations")
    public List<Reservation> search(){
        return service.search();
    }
}
