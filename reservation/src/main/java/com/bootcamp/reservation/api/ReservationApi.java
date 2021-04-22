package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class ReservationApi {
    private final ReservationRepository reservationRepository;

    public ReservationApi(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping(value = "/{uuid}")
    public Optional<Reservation> findReservationById(@PathVariable UUID uuid) {
        return reservationRepository.findReservation(uuid);
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationRepository.findAllReservations();
    }

    @PostMapping
    public UUID createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.createReservation(reservation);
    }
}
