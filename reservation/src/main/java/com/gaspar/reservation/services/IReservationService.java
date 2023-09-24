package com.gaspar.reservation.services;

import com.gaspar.reservation.model.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> search();

    List<Reservation> searchByRoom(long idRoom);
}
