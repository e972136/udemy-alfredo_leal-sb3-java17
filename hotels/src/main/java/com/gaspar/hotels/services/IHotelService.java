package com.gaspar.hotels.services;

import com.gaspar.hotels.model.Hotel;
import com.gaspar.hotels.model.responses.HotelRooms;

import java.util.List;

public interface IHotelService {

    List<Hotel> search();

    HotelRooms roomsByHotel(long hotelId);
}
