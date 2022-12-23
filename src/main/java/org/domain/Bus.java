package org.domain;

import static org.domain.BusStatus.REST;
import static org.domain.BusStatus.RUNNING;

public class Bus extends Vehicle{

    private static Long sequence = 0L;
    private static final Integer maxPassenger = 30;
    private BusStatus status;

    public Bus() {
        super();
        this.id = sequence++;
        this.status = RUNNING;
        this.charge = 1000;
    }

    public void run() {
        if (isNotRunnable("MESSAGE : [주유가 필요합니다]")) {
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

    private void quit() {
        this.status = REST;
    }



    public BusStatus getStatus() {
        return status;
    }

}
