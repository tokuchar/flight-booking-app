package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.ReservationRepositoryImpl;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class ReservationApi {

    private final ReservationRepositoryImpl reservationRepositoryImpl;

    public ReservationApi(ReservationRepositoryImpl reservationRepositoryImpl) {
        this.reservationRepositoryImpl = reservationRepositoryImpl;
    }

    @PostMapping
    public void saveReservation(@RequestBody Reservation reservation) {
        reservationRepositoryImpl.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") UUID id) {
        return reservationRepositoryImpl.findReservation(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationRepositoryImpl.findAllReservations();
    }
}
