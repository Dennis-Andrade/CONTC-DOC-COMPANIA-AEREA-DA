package com.edteam.reservations.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.edteam.reservations.event.ReservationEvent;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class ReservationEventControllerTest {

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToController(new ReservationEventController()).build();
    }

    @Test
    void streamsOnlyValidReservations() {
        List<ReservationEvent> reservations = webTestClient.get().uri("/api/reservations/stream").exchange()
                .expectStatus().isOk().expectBodyList(ReservationEvent.class).returnResult().getResponseBody();

        assertEquals(3, reservations.size());
        assertTrue(reservations.stream().allMatch(event -> event.getPrice() > 0));
        assertTrue(reservations.stream().allMatch(event -> !event.getEmails().isEmpty()));
    }
}
