package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.dtos.ReservationDTO;
import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.repositories.IReservationRepository;
import com.oyakatasushi.core.repositories.ReservationRepositoryImpl;
import com.oyakatasushi.core.services.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/reservation")
public class ReservationRessource {

    private IReservationRepository reservationRepository;
    private IReservationService reservationService;
    private EmailSenderService emailSenderService;
    private IModelMapperProvider modelMapperProvider;

    public ReservationRessource(){
        this.reservationRepository = new ReservationRepositoryImpl();
        this.emailSenderService = new EmailSenderService();
        this.modelMapperProvider = new ModelMapperProvider();
        this.reservationService = new ReservationServiceImpl(this.reservationRepository, this.emailSenderService, this.modelMapperProvider);
    }

    @GET
    @Path("/totalCustomerReservations/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReservationDTO> getCustomerReservations(@PathParam("id") Integer customerId){
        return this.reservationService.getCustomerReservations(customerId);
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
