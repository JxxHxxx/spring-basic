package org.domain.v2.taxi;

import org.domain.v2.Drivable;
import org.domain.v2.Member;
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

    public void pay() {
        if (!nowStatus(RUNNING)) {
            System.out.println("MESSAGE : [탑승중인 손님이 존재하지 않아 결제가 불가능합니다.]");
            return;
        }
        Integer charge = calculateCharge();
        this.wallet += charge;
        System.out.println("MESSAGE : [목적지 " + this.destination + "에 도착하였습니다.]");
        System.out.println("MESSAGE : [요금은 " + charge + "원 입니다.]");
        this.status = NORMAL;
    }

    private Integer calculateCharge() {
        if (Taxi.basicDistance >= this.distance) {
            return basicCharge;
        }
        else {
            int calDistance = this.distance - Taxi.basicDistance;
            return calDistance * ratePerDistance + basicCharge;
        }
    }

    public String getDestination() {
        return destination;
    }

    public Integer getDistance() {
        return distance;
    }
}
