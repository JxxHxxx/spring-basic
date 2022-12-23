package org.domain;

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



    public BusStatus getStatus() {
        return status;
    }

}
