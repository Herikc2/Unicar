package com.example.unicar.model;

import java.util.Date;

public class Ride {

    private String id;
    private String codigo_usuario;
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

    public Ride(String codigo_usuario, Address start, Address destination, Date date, int seatAmt, boolean paid, double cost, String message) {
        this.codigo_usuario = codigo_usuario;
        this.start = start;
        this.destination = destination;
        this.date = date;
        this.seatAmt = seatAmt;
        this.paid = paid;
        this.cost = cost;
        this.message = message;
    }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
