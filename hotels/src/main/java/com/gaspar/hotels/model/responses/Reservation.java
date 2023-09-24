package com.gaspar.hotels.model.responses;
import java.util.Date;
public record Reservation(long reservationId,long roomId,Date startDt,Date finishDt) {
}
