package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.ReservationRepository;
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

    private final ReservationRepository reservationRepository;

    public ReservationApi(ReservationRepositoryImpl reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping
    public void saveReservation(@RequestBody Reservation reservation) {
        reservationRepository.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") UUID id) {
        return reservationRepository.findReservation(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAllReservations();
    }
}
