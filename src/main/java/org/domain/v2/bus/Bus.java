package org.domain.v2.bus;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;
import org.domain.v2.valid.CapacityValidator;
import org.domain.v2.valid.Validator;

import static org.domain.v2.bus.BusStatus.RUNNING;

public class Bus extends Vehicle<BusStatus> implements Drivable<Integer> {

    private static Long sequence = 0L;
    public static final Integer maxPassenger = 30;

    private static final Validator capacityValidator = CapacityValidator.getInstance();

    public Bus() {
        super();
        this.id = sequence++;
        this.status = RUNNING;
        this.basicCharge = 1000;

    }

    @Override
    public void drive(Integer passenger) {
        if (!nowStatus(RUNNING)) {
            System.out.println("MESSAGE : [운행중인 버스가 아닙니다.]");
            return;
        }
        this.passenger += passenger;

        if (capacityValidator.execute(this, maxPassenger)) {
            System.out.println("MESSAGE : [최대 승객 수를 초과했습니다.]");
            this.passenger -= passenger;
        }
    }

    private boolean nowStatus(BusStatus status) {
        return this.status.equals(status);
    }

    public void setStatus(BusStatus status) {
        this.status = status;
    }
}
