package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;

import java.util.Calendar;

public class ReservationServiceImpl implements IReservationService{

    IReservationRepository reservationRepository;
    EmailSenderService emailSenderService;

    public ReservationServiceImpl(IReservationRepository reservationRepository, EmailSenderService emailSenderService){
        this.reservationRepository = reservationRepository;
        this.emailSenderService = emailSenderService;

    }
    @Override
    public Reservation createReservation(Reservation reservation) {
        // Vérifier que la date n'est pas un lundi
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reservation.getReservationDate());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.MONDAY) {
            throw new IllegalArgumentException("Les réservations ne sont pas possibles les lundis.");
        }
        Reservation createdReservation = this.reservationRepository.createReservation(reservation);
        this.emailSenderService.sendConfirmationEmail(reservation);
        return createdReservation;
    }

    @Override
    public long getNumberTotalOfReservation() {
        return this.reservationRepository.getNumberTotalOfReservation();
    }
}
