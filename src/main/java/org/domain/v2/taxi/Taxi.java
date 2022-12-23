package org.domain.v2.taxi;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;
import org.domain.v2.valid.CapacityValidator;
import org.domain.v2.valid.Validator;

import static org.domain.v2.taxi.TaxiStatus.NORMAL;
import static org.domain.v2.taxi.TaxiStatus.RUNNING;

public class Taxi extends Vehicle<TaxiStatus> implements Drivable<Member>{

    private static Long sequence = 0L;
    public static final Integer ratePerDistance = 1000;
    public static final Integer maxPassenger = 4;
    public static final Integer basicDistance = 1;


    private static final Validator capacityValidator = CapacityValidator.getInstance();

    private Integer distance;
    private String destination;

    public Taxi() {
        this.id = sequence++;
        this.basicCharge = 3000;
        this.status = NORMAL;
    }

    @Override
    public void drive(Member member) {
        if (!nowStatus(NORMAL)) {
            System.out.println("MESSAGE : [현재 택시의 상태 : " + this.status + ". 탑승이 불가능합니다.]");
            return;
        }

        this.passenger = member.getNumber();

        if (capacityValidator.execute(this, 4)) {
            System.out.println("MESSAGE : [수용 인원이 초과되어 승객을 태울 수 없습니다.]");
            this.passenger = 0;
            return;
        }

        this.destination = member.getDestination();
        this.distance = member.getDistance();
        this.status = RUNNING;
    }

    private boolean nowStatus(TaxiStatus status) {
        return this.status.equals(status);
    }


    @Override
    public void run() {

    }



}
