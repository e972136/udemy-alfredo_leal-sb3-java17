package com.gaspar.hotels.services.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.gaspar.hotels.model.responses.Room;
import java.util.List;

@FeignClient("rooms")
public interface RoomFeignClient {
    @GetMapping("/rooms/byHotel/{hotelId}")
     List<Room> searchByHotel(
            @PathVariable long hotelId
    );
}
