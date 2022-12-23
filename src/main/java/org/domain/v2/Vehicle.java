package org.domain.v2;

public abstract class Vehicle<T> implements Drivable, StateConverter{
    String id;
    Integer fuel;
    Integer speed;
    Integer maxPassenger;
    Integer passenger;
    T status;

    public Vehicle() {
        this.fuel = 100;
        this.speed = 0;
    }
}
