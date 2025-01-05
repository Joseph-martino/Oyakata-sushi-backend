package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.ReservationDTO;
import com.oyakatasushi.core.entities.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation createReservation(Reservation reservation);
    long getNumberTotalOfReservation();
    List<ReservationDTO> getCustomerReservations(Integer customerId);
}
