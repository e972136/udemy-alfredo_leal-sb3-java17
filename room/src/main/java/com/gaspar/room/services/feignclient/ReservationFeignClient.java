package com.gaspar.room.services.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("reservations") //el nombre como el servicio se registra en eureka
public interface ReservationFeignClient {

    @GetMapping("/reservations/byroom/{idRoom}")
    List<Reservation> searchByRoom(
            @PathVariable long idRoom
    );

}
