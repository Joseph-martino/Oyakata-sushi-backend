package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Reservation;

public interface IReservationService {

    Reservation createReservation(Reservation reservation);
    long getNumberTotalOfReservation();
}
