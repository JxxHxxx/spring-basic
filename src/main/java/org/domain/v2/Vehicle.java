package org.domain.v2;

public abstract class Vehicle<Status> {
    protected Long id;
    protected Integer fuel;
    protected Integer speed;
    protected Integer passenger;
    protected Integer basicCharge;
    protected Integer wallet;
    protected Status status;

    public Vehicle() {
        this.fuel = 100;
        this.speed = 0;
        this.passenger = 0;
        this.wallet = 0;
    }

    public Integer getPassenger() {
        return passenger;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getBasicCharge() {
        return basicCharge;
    }

    public Integer getWallet() {
        return wallet;
    }
}
