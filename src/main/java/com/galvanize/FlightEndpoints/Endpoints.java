package com.galvanize.FlightEndpoints;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class Endpoints {
    @GetMapping("/flights")
    public List<Flight> getFlights(){
        Flight.Passenger robert = new Flight.Passenger();
        robert.setFirstName("Robert");
        robert.setLastName("Cameron");
        Flight.Passenger alden = new Flight.Passenger();
        alden.setFirstName("Alden");
        alden.setLastName("Davidson");
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setDepartsOn(LocalDateTime.of(2020,12,31,22,2));
        flight1.setPrice(200);
        flight1.setTickets(robert, alden);
        Flight flight2 = new Flight();
        flight2.setId(2);
        flight2.setDepartsOn(LocalDateTime.of(2020,12,25,22,2));
        flight2.setPrice(200);
        flight2.setTickets(robert, alden);
        return Arrays.asList(flight1, flight2);
    }
    @GetMapping("/flights/flight")
    public List<Flight> getFlight(){
        Flight.Passenger robert = new Flight.Passenger();
        robert.setFirstName("Robert");
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setDepartsOn(LocalDateTime.of(2020,12,31,22,2));
        flight1.setPrice(200);
        flight1.setTickets(robert);
        return Collections.singletonList(flight1);
    }
}
