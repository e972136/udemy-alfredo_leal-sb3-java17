package com.gaspar.reservation.dao;

import com.gaspar.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationDao extends JpaRepository<Reservation,Long> {
}
