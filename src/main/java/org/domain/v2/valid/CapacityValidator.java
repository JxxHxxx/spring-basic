package org.domain.v2.valid;

import org.domain.v2.Vehicle;

public class CapacityValidator implements Validator{

    private CapacityValidator() {
    }

    public static CapacityValidator getInstance() {
        return new CapacityValidator();
    }

    @Override
    public boolean execute(Vehicle vehicle, Integer limit) {
        return vehicle.getPassenger() > limit;
    }
}
