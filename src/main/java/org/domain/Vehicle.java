package org.domain;

public abstract class Vehicle {
    Long id;
    Integer gasAmount;
    Integer charge;
    Integer speed;
    Integer passenger;

    public Vehicle() {
        this.gasAmount = 100;
        this.speed = 0;
        this.passenger = 0;
    }
}