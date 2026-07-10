package com.edteam.reservations.controller;

import com.edteam.reservations.event.ReservationEvent;
import com.edteam.reservations.event.ReservationEventStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reservations")
public class ReservationEventController {

    @GetMapping("/stream")
    public Flux<ReservationEvent> streamReservations() {
        return ReservationEventStream.processedReservations();
    }
}
