package com.gaspar.room.dao;

import com.gaspar.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByHotelId(long hotelId);
}
