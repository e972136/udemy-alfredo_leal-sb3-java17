package com.gaspar.hotels.model.responses;

import com.gaspar.hotels.model.Hotel;

import java.util.List;

public record HotelRooms(long hotelId, String hotelName, String hotelAddress, List<Room> rooms) {
    public static HotelRooms of(Hotel hotel, List<Room> rooms){
        return new HotelRooms(hotel.getHotelId(),hotel.getHotelName(), hotel.getHotelAddress(),rooms);
    }
}
