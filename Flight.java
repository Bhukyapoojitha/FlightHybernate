package com.wipro.Example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")

@NamedQuery(
    name = "Flight.findBySource",
    query = "from Flight f where f.source = :src"
)

@NamedNativeQuery(
    name = "Flight.findAll",
    query = "select * from flight",
    resultClass = Flight.class
)

public class Flight {

    @Id
    private int flightId;

    private String flightName;

    private String source;

    private String destination;

    private double price;

    // Default Constructor
    public Flight() {}

    // Parameterized Constructor
    public Flight(int flightId, String flightName, String source,
                  String destination, double price) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // Getters and Setters
    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }

    public String getFlightName() { return flightName; }
    public void setFlightName(String flightName) { this.flightName = flightName; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return flightId + " | " + flightName + " | " +
               source + " -> " + destination + " | Rs." + price;
    }
}
