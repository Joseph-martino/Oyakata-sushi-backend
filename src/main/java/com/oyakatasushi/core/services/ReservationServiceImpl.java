package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;

public class ReservationServiceImpl implements IReservationService{

    IReservationRepository reservationRepository;
    EmailSenderService emailSenderService;

    public ReservationServiceImpl(IReservationRepository reservationRepository, EmailSenderService emailSenderService){
        this.reservationRepository = reservationRepository;
        this.emailSenderService = emailSenderService;

    }
    @Override
    public Reservation createReservation(Reservation reservation) {
        Reservation createdReservation = this.reservationRepository.createReservation(reservation);
        this.emailSenderService.sendConfirmationEmail(reservation);
        return createdReservation;
    }

    @Override
    public long getNumberTotalOfReservation() {
        return this.reservationRepository.getNumberTotalOfReservation();
    }
}
