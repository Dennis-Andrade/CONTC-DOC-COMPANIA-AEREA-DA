package com.edteam.reservations.event;

import java.util.Objects;
import java.util.function.Predicate;

public final class ReservationFilters {

    private ReservationFilters() {
    }

    public static final Predicate<ReservationEvent> VALID_RESERVATION = event -> Objects.nonNull(event)
            && Objects.nonNull(event.getPrice()) && event.getPrice() > 0 && Objects.nonNull(event.getEmails())
            && !event.getEmails().isEmpty();
}
