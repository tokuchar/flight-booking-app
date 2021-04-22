package com.bootcamp.reservation.api;

import com.bootcamp.reservation.mapper.ReservationMapper;
import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.ReservationEntity;
import com.bootcamp.reservation.repository.ReservationRepository;
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
    private final ReservationMapper mapper;

    public ReservationApi(ReservationRepository reservationRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
    }

    @PostMapping
    public void saveReservation(@RequestBody Reservation reservation) {
        reservationRepository.createReservation(mapper.mapToReservationEntity(reservation));
    }

    @GetMapping("/{id}")
    public Optional<ReservationEntity> getReservation(@PathVariable("id") UUID id) {
        return reservationRepository.findReservation(id);
    }

    @GetMapping
    public List<ReservationEntity> getAllReservations(){
        return reservationRepository.findAllReservations();
    }

}
