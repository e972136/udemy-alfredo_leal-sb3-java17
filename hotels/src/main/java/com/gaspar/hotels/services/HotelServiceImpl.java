package com.gaspar.hotels.services;

import com.gaspar.hotels.dao.HotelRepository;
import com.gaspar.hotels.model.Hotel;
import com.gaspar.hotels.model.responses.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static java.util.Objects.isNull;

@Service
public class HotelServiceImpl implements IHotelService{

    private final RestTemplate clientRest;

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(RestTemplate clientRest, HotelRepository hotelDao) {
        this.clientRest = clientRest;
        this.hotelRepository = hotelDao;
    }

    @Override
    public List<Hotel> search() {
        return hotelRepository.findAll();
    }

    @Override
    public HotelRooms roomsByHotel(long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        if(isNull(hotel)){
            return null;
        }

        Map<String, Long> pathVariable = new HashMap<>();
        pathVariable.put("hotelId",hotelId);

        List<Room> rooms = Arrays.asList(clientRest.getForObject(
                "http://localhost:9091/rooms/byHotel/{hotelId}"
                ,Room[].class
                ,pathVariable));


        return HotelRooms.of(hotel,rooms);
    }

    @Override
    public HotelReservations findReservationsByHotel(long hotelId) {
        HotelRooms hotelRooms = roomsByHotel(hotelId);
        if(isNull(hotelRooms)){
            return null;
        }

        List<Reservations> reservations = new ArrayList<>();
        for(Room room:hotelRooms.rooms()){
            Map<String, Long> pathVariable = new HashMap<>();
            pathVariable.put("idRoom",room.roomId());
            List<Reservation> reservationsObtaind = Arrays.asList(Objects.requireNonNull(clientRest.getForObject(
                    "http://localhost:9092/reservations/byroom/{idRoom}"
                    , Reservation[].class
                    , pathVariable
            )));
//            reservationId, String roomName, Date startDt, Date finishDt
            reservationsObtaind.forEach(
                    i->reservations.add(new Reservations(i.reservationId(), room.roomName(), i.startDt(),i.finishDt()))
                    );
        }
        return HotelReservations.of(hotelRooms.hotelName(),reservations);
    }
}
