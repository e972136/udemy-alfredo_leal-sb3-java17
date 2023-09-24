package com.gaspar.room.services.feignclient;
import java.util.Date;
public record Reservation(long reservationId,long roomId,Date startDt,Date finishDt) {
}
