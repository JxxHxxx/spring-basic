package org.domain.v2.bus;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;

public class Bus extends Vehicle<BusStatus> implements Drivable<Integer> {

    @Override
    public void drive(Integer passenger) {

    }
}
