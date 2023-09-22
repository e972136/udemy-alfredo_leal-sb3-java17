package com.gaspar.room.services;

import com.gaspar.room.dao.RoomRepository;
import com.gaspar.room.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService{

    private final RoomRepository roomDao;

    public RoomServiceImpl(RoomRepository roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<Room> search() {
        return roomDao.findAll();
    }

    @Override
    public List<Room> searchByHotel(long hotelId) {
        return roomDao.findByHotelId(hotelId);
    }
}
