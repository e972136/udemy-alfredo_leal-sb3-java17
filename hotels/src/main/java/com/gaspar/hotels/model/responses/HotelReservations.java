package com.gaspar.hotels.model.responses;

import java.util.List;

public record HotelReservations(String hotelName,List<Reservations> reservations ) {
    public static HotelReservations of(String hotelName, List<Reservations> reservations){
        return new HotelReservations(hotelName,reservations);
    }
}
