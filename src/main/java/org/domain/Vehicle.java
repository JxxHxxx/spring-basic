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
    public Integer getPassenger() {
        return passenger;
    }

    public Integer getGasAmount() {
        return gasAmount;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Long getId() {
        return id;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setGasAmount(Integer gasAmount) {
        int tmpGasAmount = this.gasAmount + gasAmount;
        if (tmpGasAmount < 0) {
            System.out.println("MESSAGE : [주유량은 0 보다 작을 수 없습니다.]");
            return;
        }
        this.gasAmount = tmpGasAmount;
    }
    public void setSpeed(Integer speed) {
        if (speedValidator()) {
            return;
        };

        int tmpSpeed = this.speed + speed;
        if (tmpSpeed < 0) {
            System.out.println("MESSAGE : [속도는 0 이상의 값을 가집니다.]");
            return;
        }
        this.speed = tmpSpeed;
    }
    public abstract boolean speedValidator();
}