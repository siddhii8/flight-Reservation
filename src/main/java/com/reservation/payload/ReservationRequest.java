package com.reservation.payload;

import lombok.Data;

@Data
public class ReservationRequest {
    private long flightId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvvCode;

}
