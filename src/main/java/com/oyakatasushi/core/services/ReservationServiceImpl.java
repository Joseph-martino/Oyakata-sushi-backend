package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;

public class ReservationServiceImpl implements IReservationService{

    IReservationRepository reservationRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    @Override
    public void createReservation(Reservation reservation) {
        this.reservationRepository.createReservation(reservation);
    }
}
