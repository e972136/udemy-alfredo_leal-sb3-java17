package com.gaspar.room.services;

import com.gaspar.room.dao.IRoomDao;
import com.gaspar.room.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService{

    private final IRoomDao roomDao;

    public RoomServiceImpl(IRoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<Room> search() {
        return roomDao.findAll();
    }
}
