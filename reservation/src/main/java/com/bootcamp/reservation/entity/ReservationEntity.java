package com.bootcamp.reservation.entity;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.TicketClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PassengerEntity passenger;
    @OneToOne(cascade = CascadeType.ALL)
    private FlightEntity flight;
    private LocalDateTime reservationDateTime;
    @Enumerated(EnumType.ORDINAL)
    private TicketClass ticketClass;
    private BigDecimal price;

    public ReservationEntity map(Reservation reservation) {
        return ReservationEntity.builder()
                .uuid(reservation.getUuid())
                .passenger(PassengerEntity.map(reservation.getPassenger()))
                .flight(FlightEntity.map(reservation.getFlight()))
                .reservationDateTime(reservation.getReservationDateTime())
                .ticketClass(reservation.getTicketClass())
                .price(reservation.getPrice())
                .build();
    }
}
