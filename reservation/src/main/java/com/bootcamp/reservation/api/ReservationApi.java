package com.bootcamp.reservation.api;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class
ReservationApi {

    private final ReservationRepository reservationRepository;

    public ReservationApi(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/create")
    public void saveReservation(Reservation reservation) {
        reservationRepository.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public String getReservation(@PathParam("id") UUID id) {
        reservationRepository.findReservation(id);
        return "index";
    }

    @GetMapping("/all")
    public String getAllReservations(){
        reservationRepository.findAllReservations();
        return "index";
    }
}
