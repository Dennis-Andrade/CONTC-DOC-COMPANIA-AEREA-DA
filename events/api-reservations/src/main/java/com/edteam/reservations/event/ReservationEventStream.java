package com.edteam.reservations.event;

import java.util.List;
import reactor.core.publisher.Flux;

public final class ReservationEventStream {

    private ReservationEventStream() {
    }

    public static Flux<ReservationEvent> sampleReservations() {
        return Flux.just(new ReservationEvent("EVT-001", "Ana Torres", 180.25, List.of("ana.torres@mail.com")),
                new ReservationEvent("EVT-002", "Luis Perez", 0.0, List.of("luis.perez@mail.com")),
                new ReservationEvent("EVT-003", "Maria Gomez", 240.50, List.of("maria.gomez@mail.com")),
                new ReservationEvent("EVT-004", "Carlos Ruiz", 95.90, List.of("carlos.ruiz@mail.com")),
                new ReservationEvent("EVT-005", "Sofia Diaz", 320.00, List.of()));
    }

    public static Flux<ReservationEvent> processedReservations() {
        return sampleReservations().filter(ReservationFilters.VALID_RESERVATION)
                .doOnNext(ReservationFilters.PRINT_PROCESSED_EVENT).defaultIfEmpty(
                        new ReservationEvent("EVT-DEFAULT", "Reserva generica", 1.0, List.of("reservas@mail.com")));
    }
}
