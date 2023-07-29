package com.gaspar.room.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long roomId;

    @Column(name = "hotel_id")
    private long hotelId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_avaible")
    private String roomAvaible;
}
