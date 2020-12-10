package com.galvanize.FlightEndpoints;

import java.util.ArrayList;

public class Tickets {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    static class Ticket{
        private Integer price;
        private  Passenger passenger;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        static class Passenger {
            private String firstName;
            private String lastName;

            public String getFirstName() { return firstName; }

            public void setFirstName(String name) { this.firstName = name; }

            public String getLastName() { return lastName; }

            public void setLastName(String name) { this.lastName = name; }
        }
    }

}
