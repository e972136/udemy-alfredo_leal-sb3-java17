package com.gaspar.hotels.dao;

import com.gaspar.hotels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IHotelDao extends JpaRepository<Hotel,Long> {
}
