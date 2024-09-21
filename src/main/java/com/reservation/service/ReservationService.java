package com.reservation.service;

import com.reservation.entity.Reservation;
import com.reservation.payload.ReservationRequest;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    Reservation bookFlight(ReservationRequest request);

}
