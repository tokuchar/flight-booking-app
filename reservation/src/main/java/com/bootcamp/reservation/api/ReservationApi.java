package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.FakeReservationRepository;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.UUID;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class ReservationApi {

    private ReservationRepository fakeReservationRepository;
    @Autowired
    public ReservationApi(ReservationRepository fakeReservationRepository) {
        this.fakeReservationRepository = fakeReservationRepository;
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable UUID reservationId){
        return fakeReservationRepository.findReservation(reservationId)
                .orElseThrow();
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return fakeReservationRepository.findAllReservations();
    }

    @PostMapping
    public void addReservation(Reservation reservation) {
        fakeReservationRepository.createReservation(reservation);
    }
}
