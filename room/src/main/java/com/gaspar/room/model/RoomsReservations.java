package com.gaspar.room.model;

import com.gaspar.room.services.feignclient.Reservation;

import java.util.List;

public record RoomsReservations(long roomId, String roomName, List<Reservation> reservations) {
    public static RoomsReservations of(long roomId, String roomName, List<Reservation> reservations) {
        return new RoomsReservations(roomId,roomName,reservations);
    }
}
