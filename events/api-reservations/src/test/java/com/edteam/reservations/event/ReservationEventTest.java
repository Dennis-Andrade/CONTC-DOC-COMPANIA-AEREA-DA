package com.edteam.reservations.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReservationEventTest {

    @Test
    void protectsEmailsFromConstructorChanges() {
        List<String> emails = new ArrayList<>();
        emails.add("ana@mail.com");

        ReservationEvent event = new ReservationEvent("EVT-001", "Ana Torres", 120.0, emails);
        emails.add("extra@mail.com");

        assertEquals(List.of("ana@mail.com"), event.getEmails());
    }

    @Test
    void protectsEmailsFromGetterChanges() {
        ReservationEvent event = new ReservationEvent("EVT-001", "Ana Torres", 120.0, List.of("ana@mail.com"));

        assertThrows(UnsupportedOperationException.class, () -> event.getEmails().add("extra@mail.com"));
        assertEquals(List.of("ana@mail.com"), event.getEmails());
    }
}
