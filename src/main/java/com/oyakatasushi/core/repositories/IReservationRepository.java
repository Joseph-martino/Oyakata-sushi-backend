package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Reservation;
import java.util.Date;

public interface IReservationRepository {

    Reservation createReservation(Reservation reservation);
    long getNumberTotalOfReservation();


}
