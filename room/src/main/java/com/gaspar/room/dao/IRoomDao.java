package com.gaspar.room.dao;

import com.gaspar.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomDao extends JpaRepository<Room,Long> {
}
