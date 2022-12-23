package org.domain;

import static org.domain.BusStatus.REST;
import static org.domain.BusStatus.RUNNING;

public class Bus extends Vehicle{

    private static Long sequence = 0L;
    private final Integer maxPassenger = 30;
    private BusStatus status;

    public Bus() {
        super();
        this.id = sequence++;
        this.status = RUNNING;
        this.charge = 1000;
    }

    public void run() {
        if (isNotRunnable("MESSAGE : [주유가 필요합니다.]")) {
            quit();
            return;
        }
        this.status = RUNNING;
    }

    private boolean isNotRunnable(String message) {
        if (this.gasAmount < 10) {
            System.out.println(message);
            return true;
        }
        return false;
    }
    public Integer ride(Integer passenger) {
        if (isNotRunning()) {
            System.out.println("MESSAGE : [운행중인 버스가 아닙니다.]");
            return null;
        }

        int tmpPassenger = this.passenger + passenger;
        if (tmpPassenger >= maxPassenger) {
            System.out.println("MESSAGE : [최대 승객 수를 초과했습니다.]");
            return null;
        }
        this.passenger = tmpPassenger;
        return passenger;
    }

    private boolean isNotRunning() {
        return !this.status.equals(RUNNING);
    }

    public void setStatus(BusStatus status) {
        this.status = status;
    }

    private void quit() {
        this.status = REST;
    }

    @Override
    public boolean speedValidator() {
        if (isNotRunning()) {
            System.out.println("MESSAGE : [운행중인 버스가 아닙니다.]");
             return true;
        }
        if (isNotRunnable("MESSAGE : [주유량을 확인해주세요.]")) {
            return true;
        }
        return false;
    }

    public BusStatus getStatus() {
        return status;
    }

    public Integer getMaxPassenger() {
        return maxPassenger;
    }
}
