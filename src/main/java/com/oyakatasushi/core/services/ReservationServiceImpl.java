package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.ReservationDTO;
import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservationServiceImpl implements IReservationService{

    private IReservationRepository reservationRepository;
    private EmailSenderService emailSenderService;
    private ModelMapper modelMapper;

    public ReservationServiceImpl(IReservationRepository reservationRepository, EmailSenderService emailSenderService,
                                  IModelMapperProvider modelMapperProvider){
        this.reservationRepository = reservationRepository;
        this.emailSenderService = emailSenderService;
        this.modelMapper = modelMapperProvider.getModelMapper();

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

    @Override
    public List<ReservationDTO> getCustomerReservations(Integer customerId) {
        List<Reservation> reservations = reservationRepository.getCustomerReservations(customerId);
        List<ReservationDTO> reservationsDTO = new ArrayList<>();
        for(Reservation reservation: reservations){
            ReservationDTO reservationDTO = this.modelMapper.map(reservation, ReservationDTO.class);
            reservationsDTO.add(reservationDTO);
        }
        return reservationsDTO;
    }
}
