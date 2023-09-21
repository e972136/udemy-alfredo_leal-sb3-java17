package com.gaspar.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    long reservationId;

    @Column(name = "room_id")
    private long roomId;

    @Column(name = "start_dt")
    private Date startDt;

    @Column(name = "finish_dt")
    private Date finishDt;

}
