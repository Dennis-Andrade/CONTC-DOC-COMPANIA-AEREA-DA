package com.edteam.reservations.event;

import java.util.List;

public final class ReservationEvent {

    private final String id;
    private final String passengerName;
    private final Double price;
    private final List<String> emails;

    public ReservationEvent(String id, String passengerName, Double price, List<String> emails) {
        this.id = id;
        this.passengerName = passengerName;
        this.price = price;
        this.emails = emails;
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
        return emails;
    }
}
