package com.gaspar.hotels.services;

import com.gaspar.hotels.dao.IHotelDao;
import com.gaspar.hotels.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{

    private final IHotelDao hotelDao;

    public HotelServiceImpl(IHotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public List<Hotel> search() {
        return hotelDao.findAll();
    }
}
