package com.galvanize.FlightEndpoints;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flight {
    private int id;
    private LocalDateTime departsOn;
    private final List<Passenger> tickets = new ArrayList<>();
    private int price;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public LocalDateTime getDepartsOn() { return departsOn; }

    public void setDepartsOn(LocalDateTime dateTime) { this.departsOn = dateTime; }

    public List<Passenger> getTickets() { return tickets; }

    public void setTickets(Passenger... passengers) {
        this.tickets.addAll(Arrays.asList(passengers));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Passenger {
        private String firstName;
        private String lastName;

        public String getFirstName() { return firstName; }

        public void setFirstName(String name) { this.firstName = name; }

        public String getLastName() { return lastName; }

        public void setLastName(String name) { this.lastName = name; }
    }
}
