package com.gaspar.hotels.model.responses;

import java.util.Date;

public record Reservations(long reservationId, String roomName, Date startDt, Date finishDt) {
}
