package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Reservation;
import java.util.Date;
import java.util.List;

public interface IReservationRepository {

    Reservation createReservation(Reservation reservation);
    long getNumberTotalOfReservation();
    List<Reservation> getCustomerReservations(Integer customerId);


}
