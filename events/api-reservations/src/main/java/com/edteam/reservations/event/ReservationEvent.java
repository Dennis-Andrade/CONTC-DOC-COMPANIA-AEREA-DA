package com.edteam.reservations.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ReservationEvent {

    private final String id;
    private final String passengerName;
    private final Double price;
    private final List<String> emails;

    @JsonCreator
    public ReservationEvent(@JsonProperty("id") String id, @JsonProperty("passengerName") String passengerName,
            @JsonProperty("price") Double price, @JsonProperty("emails") List<String> emails) {
        this.id = id;
        this.passengerName = passengerName;
        this.price = price;
        this.emails = new ArrayList<>(Objects.requireNonNullElse(emails, Collections.emptyList()));
    }

    public String getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Double getPrice() {
        return price;
    }

    public List<String> getEmails() {
        return Collections.unmodifiableList(new ArrayList<>(emails));
    }
}
