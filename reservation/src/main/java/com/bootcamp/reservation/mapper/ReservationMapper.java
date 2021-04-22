package com.bootcamp.reservation.mapper;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationEntity mapToReservationEntity(Reservation reservation) {
            return new ReservationEntity(
                    reservation.getUuid(),
                    reservation.getFlightId(),
                    reservation.getReservationDateTime(),
                    reservation.getTicketClass(),
                    reservation.getPrice(),
                    reservation.getPassenger()
            );
    }
}
