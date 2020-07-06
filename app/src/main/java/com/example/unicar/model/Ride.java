package com.example.unicar.model;

import java.util.Date;

public class Ride {
    private Address start;
    private Address destination;
    private Date date;
    private int seatAmt;
    private boolean paid;
    private double cost;
    private String message;

    public Ride(Address start, Address destination, Date date, int seatAmt, boolean paid, double cost, String message) {
        this.start = start;
        this.destination = destination;
        this.date = date;
        this.seatAmt = seatAmt;
        this.paid = paid;
        this.cost = cost;
        this.message = message;
    }

    public Address getStart() {
        return start;
    }

    public void setStart(Address start) {
        this.start = start;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeatAmt() {
        return seatAmt;
    }

    public void setSeatAmt(int seatAmt) {
        this.seatAmt = seatAmt;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
