package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class ReservationApi {
    private ReservationRepository reservationRepository;

    public ReservationApi(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    //TODO: wstrzyknąć sobie jakoś Repository

    @GetMapping
    public String helloWorld(){
        return "hello";
    }
    @GetMapping
    public Optional<Reservation> findReservationById(UUID uuid){
        return reservationRepository.findReservation(uuid);
    }

    @GetMapping
    public List<Reservation> findAll(){
        return reservationRepository.findAllReservations();
    }

    @PostMapping
    public UUID createReservation(Reservation reservation){
        return reservationRepository.createReservation(reservation);
    }
    //TODO: metody http GET po UUID, GET dla wszystkich, POST
}
