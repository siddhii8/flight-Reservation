package com.reservation.controller;

import com.reservation.entity.Reservation;
import com.reservation.payload.ReservationRequest;
import com.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
@Autowired
private ReservationService reservationService;

    @RequestMapping("/confirmReservation")
 public String confirmReservation(ReservationRequest request, ModelMap modelMap){
        Reservation reservationId = reservationService.bookFlight(request);
        modelMap.addAttribute("reservationId", reservationId);
        return "confirmReservation";
 }
}
