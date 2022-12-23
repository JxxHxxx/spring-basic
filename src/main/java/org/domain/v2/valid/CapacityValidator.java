package org.domain.v2.valid;

import org.domain.v2.Vehicle;
import org.domain.v2.bus.Bus;
import org.domain.v2.taxi.Taxi;

public class CapacityValidator implements Validator{

    private CapacityValidator() {
    }

    public static CapacityValidator getInstance() {
        return new CapacityValidator();
    }

    @Override
    public boolean execute(Vehicle vehicle) {

        if (vehicle instanceof Bus) {
            return vehicle.getPassenger() > Bus.maxPassenger;
        }

        if (vehicle instanceof Taxi) {
            return vehicle.getPassenger() > Taxi.maxPassenger;
        }

        return false;
    }
}
