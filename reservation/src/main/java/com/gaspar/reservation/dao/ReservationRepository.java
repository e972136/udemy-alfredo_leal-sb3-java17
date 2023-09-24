package com.gaspar.reservation.dao;

import com.gaspar.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByRoomId(long idRoom);
}
