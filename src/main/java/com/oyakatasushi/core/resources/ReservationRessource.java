package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;
import com.oyakatasushi.core.repositories.ReservationRepositoryImpl;
import com.oyakatasushi.core.services.EmailSenderService;
import com.oyakatasushi.core.services.IReservationService;
import com.oyakatasushi.core.services.ReservationServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Reservation createReservation(Reservation reservation){
        this.reservationService.createReservation(reservation);
        return reservation;
    }

    @GET
    @Path("/total")
    @Produces(MediaType.APPLICATION_JSON)
    public long getNumberTotalOfReservations(){
        System.out.println("total: " + this.reservationService.getNumberTotalOfReservation());
        return this.reservationService.getNumberTotalOfReservation();
    }
}
