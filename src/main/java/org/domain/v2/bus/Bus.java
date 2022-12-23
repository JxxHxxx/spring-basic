package org.domain.v2.bus;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;

import static org.domain.v2.bus.BusStatus.RUNNING;

public class Bus extends Vehicle<BusStatus> implements Drivable<Integer> {

    private static Long sequence = 0L;
    private static final Integer maxPassenger = 30;

    public Bus() {
        super();
        this.id = sequence++;
        this.status = RUNNING;
        this.basicCharge = 1000;

    }

    @Override
    public void drive(Integer passenger) {

    }
}
