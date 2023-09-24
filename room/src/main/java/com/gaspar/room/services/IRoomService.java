package com.gaspar.room.services;
import com.gaspar.room.model.Room;

import java.util.List;
import com.gaspar.room.model.RoomsReservations;
public interface IRoomService {
    List<Room> search();

    List<Room> searchByHotel(long hotelId);

    RoomsReservations searchReservationsByRoom(long roomId);
}
