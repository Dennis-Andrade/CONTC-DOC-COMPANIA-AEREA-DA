package com.edteam.reservations.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ReservationFiltersTest {

    @Test
    void acceptsValidReservation() {
        ReservationEvent event = new ReservationEvent("EVT-001", "Ana Torres", 120.0, List.of("ana@mail.com"));

        assertTrue(ReservationFilters.VALID_RESERVATION.test(event));
    }

    @Test
    void rejectsInvalidReservations() {
        assertFalse(ReservationFilters.VALID_RESERVATION
                .test(new ReservationEvent("EVT-002", "Luis Perez", 0.0, List.of("luis@mail.com"))));
        assertFalse(ReservationFilters.VALID_RESERVATION
                .test(new ReservationEvent("EVT-003", "Maria Gomez", -10.0, List.of("maria@mail.com"))));
        assertFalse(ReservationFilters.VALID_RESERVATION
                .test(new ReservationEvent("EVT-004", "Carlos Ruiz", 50.0, List.of())));
        assertFalse(ReservationFilters.VALID_RESERVATION.test(null));
    }
}
