package com.gaspar.room.services;

import com.gaspar.room.dao.RoomRepository;
import com.gaspar.room.model.Room;

import com.gaspar.room.model.RoomsReservations;
import com.gaspar.room.services.feignclient.Reservation;
import com.gaspar.room.services.feignclient.ReservationFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class RoomServiceImpl implements IRoomService{

    private final RoomRepository roomRepository;
    private final ReservationFeignClient feignClient;

    public RoomServiceImpl(RoomRepository roomRepository, ReservationFeignClient feignClient) {
        this.roomRepository = roomRepository;
        this.feignClient = feignClient;
    }

    @Override
    public List<Room> search() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> searchByHotel(long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @Override
    public RoomsReservations searchReservationsByRoom(long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if(isNull(room)){
            return null;
        }
        List<Reservation> reservations = feignClient.searchByRoom(roomId);

        return RoomsReservations.of(room.getRoomId(),room.getRoomName(),reservations);
    }
}
