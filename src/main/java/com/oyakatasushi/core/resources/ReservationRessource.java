package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;
import com.oyakatasushi.core.repositories.ReservationRepositoryImpl;
import com.oyakatasushi.core.services.EmailSenderService;
import com.oyakatasushi.core.services.IReservationService;
import com.oyakatasushi.core.services.ReservationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/reservation")
public class ReservationRessource {

    IReservationRepository reservationRepository;
    IReservationService reservationService;
    EmailSenderService emailSenderService;

    public ReservationRessource(){
        this.reservationRepository = new ReservationRepositoryImpl();
        this.emailSenderService = new EmailSenderService();
        this.reservationService = new ReservationServiceImpl(this.reservationRepository, this.emailSenderService);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Reservation createReservation(Reservation reservation){
        System.out.println("Received reservation request: " + reservation);
        Reservation createdReservation = this.reservationService.createReservation(reservation);
        System.out.println("Reservation created: " + createdReservation);
        return createdReservation;
    }

    @GET
    @Path("/total")
    @Produces(MediaType.APPLICATION_JSON)
    public long getNumberTotalOfReservations(){
        return this.reservationService.getNumberTotalOfReservation();
    }
}
