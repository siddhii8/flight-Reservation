package com.reservation.serviceImpl;

import com.reservation.entity.Flight;
import com.reservation.entity.Passenger;
import com.reservation.entity.Reservation;
import com.reservation.payload.ReservationRequest;
import com.reservation.repository.FlightRepository;
import com.reservation.repository.PassengerRepository;
import com.reservation.repository.ReservationRepository;
import com.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.BootstrapContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

@Autowired
private PassengerRepository passengerRepo;

@Autowired
private FlightRepository flightRepo;

@Autowired
private ReservationRepository reservationRepo;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setMiddleName(request.getMiddleName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());

        long flightId = request.getFlightId();
        Optional<Flight> findById = flightRepo.findById(flightId);
        Flight flight = findById.get();

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(0);

        reservationRepo.save(reservation);
        return reservation;
    }
}
