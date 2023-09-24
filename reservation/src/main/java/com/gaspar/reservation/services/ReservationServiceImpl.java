package com.gaspar.reservation.services;

import com.gaspar.reservation.dao.ReservationRepository;
import com.gaspar.reservation.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationDao) {
        this.reservationRepository = reservationDao;
    }

    @Override
    public List<Reservation> search() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> searchByRoom(long idRoom) {
        return reservationRepository.findByRoomId(idRoom);
    }
}
