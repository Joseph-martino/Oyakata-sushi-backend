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
    public void createReservation(Reservation reservation) {
        System.out.println("coucoi c'est le service");
        this.reservationRepository.createReservation(reservation);
        this.emailSenderService.sendConfirmationEmail(reservation);
        System.out.println("fin service");
    }

    @Override
    public long getNumberTotalOfReservation() {
        return this.reservationRepository.getNumberTotalOfReservation();
    }
}
