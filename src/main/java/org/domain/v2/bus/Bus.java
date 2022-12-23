package org.domain.v2.bus;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;

import static org.domain.v2.bus.BusStatus.RUNNING;

public class Bus extends Vehicle<BusStatus> implements Drivable<Integer> {

    private static Long sequence = 0L;
    public static final Integer maxPassenger = 30;

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

        int tmpPassenger = this.passenger + passenger;
        if (tmpPassenger >= maxPassenger) {
            System.out.println("MESSAGE : [최대 승객 수를 초과했습니다.]");
            return;
        }
        this.passenger = tmpPassenger;

    }
}
