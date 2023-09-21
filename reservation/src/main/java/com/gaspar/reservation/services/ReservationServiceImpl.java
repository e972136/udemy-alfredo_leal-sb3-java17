package com.gaspar.reservation.services;

import com.gaspar.reservation.dao.IReservationDao;
import com.gaspar.reservation.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService{
    private final IReservationDao reservationDao;

    public ReservationServiceImpl(IReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public List<Reservation> search() {
        return reservationDao.findAll();
    }
}
